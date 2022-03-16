/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.add;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import controller.auth.BaseAuthController;
import dal.ProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Company;
import model.OrderDetail;
import model.OrderHistory;
import model.Product;

/**
 *
 * @author ADMIN
 */
public class CheckoutController extends BaseAuthController {

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
        String[] quantity_raw = request.getParameterValues("quantity");
        String[] discount_raw = request.getParameterValues("discount");
        int cid = Integer.parseInt(request.getParameter("cid"));
        String[] pid_raw = request.getParameterValues("pid");
        String[] cost_raw = request.getParameterValues("cost");
        String[] name_raw = request.getParameterValues("name");
        float total = Float.parseFloat(request.getParameter("total"));
        ArrayList<Integer> quantitys = new ArrayList<>();
        ArrayList<Float> discounts = new ArrayList<>();
        ArrayList<Integer> pids = new ArrayList<>();
        ArrayList<Float> costs = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < quantity_raw.length; i++) {
            quantitys.add(Integer.parseInt(quantity_raw[i]));
            discounts.add(Float.parseFloat(discount_raw[i]));
            costs.add(Float.parseFloat(cost_raw[i]));
            names.add(name_raw[i]);
            pids.add(Integer.parseInt(pid_raw[i]));
        }
        int check = 0;
        //validation paid
        String paid_raw = request.getParameter("paid");
        String maturityDate_raw = request.getParameter("maturityDate");
        if (paid_raw == null || paid_raw.trim().length() == 0) {
            paid_raw = "0";
        }
        float paid = Float.parseFloat(paid_raw);
        if (paid < 0) {
            check = 1;
            request.setAttribute("paid_error", "Số tiền thanh toán không hợp lệ, xin vui lòng nhập lại!");
        } else if (paid > total) {
            request.setAttribute("paid_error", "Số tiền thanh toán không được lớn hơn tổng số tiền của đơn hàng");
            check = 1;
        } else {
            request.setAttribute("paid", paid);
        }
        //validation maturity Date

        ProductDBContext pDb = new ProductDBContext();
        Date maturityDate = null;
        if (maturityDate_raw == null || maturityDate_raw.trim().length() == 0) {
            request.setAttribute("maturityDate_error", "Chưa nhập ngày thanh toán");
            check = 1;
        } else {
            maturityDate = Date.valueOf(maturityDate_raw);
            if (maturityDate.before(pDb.getNow())) {
                request.setAttribute("maturityDate_error", "Hạn trả không được lớn hơn ngày hôm nay");
                check = 1;
            } else {
                request.setAttribute("maturityDate", maturityDate);
            }
        }
        
        if (check == 0) {
            int id = pDb.getBigestOrderId() + 1;
            ArrayList<Product> prodcuts = new ArrayList<>();
            ArrayList<OrderDetail> orderdetail = new ArrayList<>();
            OrderHistory orderHistory = new OrderHistory();
            orderHistory.setId(id);
            orderHistory.setPaid(paid);
            orderHistory.setMaturityDate(maturityDate);
           
            for (int i = 0; i < quantitys.size(); i++) {
                Product product = new Product();
                OrderDetail od = new OrderDetail();
                product.setId(pids.get(i));
                od.setDiscount(discounts.get(i)*0.01f);
                od.setQuantity(quantitys.get(i));
                prodcuts.add(product);
                orderdetail.add(od);
            }
            pDb.insertOrder(prodcuts,orderHistory,orderdetail,cid);
            response.sendRedirect("../info/company?cid=" + cid);
        } else {
            request.setAttribute("cid", cid);
            request.setAttribute("names", names);
            request.setAttribute("costs", costs);
            request.setAttribute("pids", pids);
            request.setAttribute("quantitys", quantitys);
            request.setAttribute("discounts", discounts);
            request.getRequestDispatcher("../view/deptManagement/company/checkout.jsp").forward(request, response);
        }
        
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
        processRequest(request, response);
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
        processRequest(request, response);
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
