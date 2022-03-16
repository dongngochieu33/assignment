/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dept;

import controller.auth.BaseAuthController;
import dal.CustomersOweDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CustomerOwe;
import model.SaleDetail;

/**
 *
 * @author ADMIN
 */
public class InfoCustomerDetailController extends BaseAuthController {

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
        int saleHistoryId = Integer.parseInt(request.getParameter("saleHistoryId"));
        String cusName = request.getParameter("cusName");
        int id = Integer.parseInt(request.getParameter("cusId"));
        String page = request.getParameter("page");
        if (page == null || page.trim().length() == 0) {
            page = "1";
        }
        int pageindex = Integer.parseInt(page);
        int pagesize = 10;
        CustomersOweDBContext db = new CustomersOweDBContext();
        int records = db.getTotalPageOfCustomerDetail(saleHistoryId);
        int totalpage = (records % pagesize == 0) ? (records / pagesize) : (records / pagesize) + 1;
        if (pageindex > totalpage) {
            pageindex = totalpage;
        } else if (pageindex <= 0) {
            pageindex = 1;
        }
        ArrayList<SaleDetail> saleDetail = db.getSaleDetailById(saleHistoryId, pageindex, pagesize);
        request.setAttribute("cusName", cusName);
        request.setAttribute("cusId", id);
        request.setAttribute("totalpage", totalpage);
        request.setAttribute("pageindex", pageindex);
        request.setAttribute("saleHistoryId", saleHistoryId);
        request.setAttribute("saleDetail", saleDetail);
        request.getRequestDispatcher("../../view/deptManagement/customer/saleDetail.jsp").forward(request, response);
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
