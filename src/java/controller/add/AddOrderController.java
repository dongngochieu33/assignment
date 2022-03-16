/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.add;

import controller.auth.BaseAuthController;
import dal.ProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author ADMIN
 */
public class AddOrderController extends BaseAuthController {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        ProductDBContext pDB = new ProductDBContext();
        ArrayList<Product> products = pDB.getProduct(cid);
        request.setAttribute("cid", cid);
        request.setAttribute("products", products);
        request.getRequestDispatcher("../view/deptManagement/company/create.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] quantity_raw = request.getParameterValues("quantity");
        String[] discount_raw = request.getParameterValues("discount");
        String[] cost_raw = request.getParameterValues("cost");
        String[] name_raw = request.getParameterValues("name");
        int cid = Integer.parseInt(request.getParameter("cid"));
        String[] pid_raw = request.getParameterValues("pid");
        ArrayList<Integer> quantitys = new ArrayList<>();
        ArrayList<Float> discounts = new ArrayList<>();
        ArrayList<Integer> pids = new ArrayList<>();
        ArrayList<Float> costs = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        
        

        for (int i = 0; i < quantity_raw.length; i++) {
            if (quantity_raw[i] != null && quantity_raw[i].trim().length() > 0) {
                quantitys.add(Integer.parseInt(quantity_raw[i]));
                if (discount_raw[i] == null || discount_raw[i].trim().length() == 0) {
                    discount_raw[i] = "0";
                }
                discounts.add(Float.parseFloat(discount_raw[i]));
                costs.add(Float.parseFloat(cost_raw[i]));
                names.add(name_raw[i]);
                pids.add(Integer.parseInt(pid_raw[i]));
            }
        }
        int check = 0;

        if (quantitys.size() == 0) {
           request.setAttribute("enternothing", "không thể thêm đơn rỗng");
            check = 1;
        }

        for (int quantity : quantitys) {
            if (quantity <= 0) {

                request.setAttribute("errorQuantity", "Số lượng phải lớn hơn hoặc bằng một");
                check = 1;
                break;
            }
        }
        for (float discount : discounts) {

            if (discount < 0 || discount > 100) {
                request.setAttribute("errorDiscount", "Chiết khấu phải trong khoảng từ 0% đến 100%");
                check = 1;
                break;
            }
        }
        
        if (check == 0) {
            
            request.setAttribute("cid", cid);
            request.setAttribute("names", names);
            request.setAttribute("costs", costs);
            request.setAttribute("pids", pids);
            request.setAttribute("quantitys", quantitys);
            request.setAttribute("discounts", discounts);
            request.getRequestDispatcher("../view/deptManagement/company/checkout.jsp").forward(request, response);
            
        } else {
            ProductDBContext pDB = new ProductDBContext();
            ArrayList<Product> products = pDB.getProduct(cid);
            request.setAttribute("products", products);
            request.setAttribute("cid", cid);
            request.getRequestDispatcher("../view/deptManagement/company/create.jsp").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
