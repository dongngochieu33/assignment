/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dept;

import dal.CompanyDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.OrderHistory;

/**
 *
 * @author ADMIN
 */
public class InfoCompanyController extends HttpServlet {

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
     int id = Integer.parseInt(request.getParameter("cid"));
     String name = request.getParameter("cname");
     String page = request.getParameter("page");
        if (page == null || page.trim().length() == 0) {
            page = "1";
        }
        Date fromDate = null;
        String date_raw = (String) request.getParameter("fromDate");
        if (date_raw != null && date_raw.trim().length() != 0) {
            fromDate = Date.valueOf(date_raw);
        }
        int pageindex = Integer.parseInt(page);
        CompanyDBContext db = new CompanyDBContext();
        int pagesize = 10;
        int records = db.getTotalPageOfOneCompanyOwe(id,fromDate);
        int totalpage = (records % pagesize == 0) ? (records / pagesize) : (records / pagesize) + 1;
        if(pageindex > totalpage) pageindex = totalpage;
        else if(pageindex <=0 )pageindex = 1;
        ArrayList<OrderHistory> companyOwes = db.getCompanyOwe(id, pageindex, pagesize, fromDate);
        Date now = db.getNow();
  
        request.setAttribute("pageindex", pageindex);
        request.setAttribute("now", now);
        request.setAttribute("totalpage", totalpage);
        request.setAttribute("fromDate", fromDate);
        request.setAttribute("cid", id);
        request.setAttribute("cname", name);
        request.setAttribute("companyOwes", companyOwes);
        request.getRequestDispatcher("../view/deptManagement/company/totalOwe.jsp").forward(request, response);
//        
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
