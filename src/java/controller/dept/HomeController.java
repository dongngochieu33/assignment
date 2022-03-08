/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dept;

import controller.auth.BaseAuthController;
import dal.AddressDBContext;
import dal.CustomersOweDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Address;
import model.CustomersOwe;

/**
 *
 * @author ADMIN
 */
public class HomeController extends BaseAuthController {

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
         int addressid = -1;
        AddressDBContext adDb = new AddressDBContext();
        ArrayList<Address> allAddress = adDb.getAllAddress();
        String addressID_raw = request.getParameter("addressid");
        if(addressID_raw == null || addressID_raw.trim().length() == 0){
            addressID_raw = "-1";
        } 
        else addressid = Integer.parseInt(addressID_raw);
         CustomersOweDBContext db = new CustomersOweDBContext();
        ArrayList<CustomersOwe> allCustomersOwe = db.getCustomersOwe(addressid);
        request.setAttribute("addressid", addressid);
        request.setAttribute("allAddress", allAddress);
        request.setAttribute("allCustomersOwe",allCustomersOwe);
         request.getRequestDispatcher("../view/deptManagement/home.jsp").forward(request, response);
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
