/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Dispositivo;
import Model.GestorBD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aidee
 */
@WebServlet(name = "addDevice", urlPatterns = {"/addDevice"})
public class add extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    //Primero te traes todos los id de la página anterior através del request (funciona igual para modificar).
         GestorBD query = new GestorBD();
         String nombre = request.getParameter("nombre");
         String disp = request.getParameter("descripcion");
         String modelo = request.getParameter("modelo");
         String marca = request.getParameter("marca");
         String p = request.getParameter("precio");
         int precio = Integer.parseInt(p);
         String color = request.getParameter("color");
     //Segundo, conectas la base de datos aquí con todo lo anterior.
     if(query.addDev(new Dispositivo(nombre,disp,modelo,marca,precio,color))){
        //Se redirecciona. No es necesario hacer un requestDispacher, ya que no estás enviando
        // nada a una página, como un setAttribute(que son atributos globales que se pasan entre
        // pagina -> servlet o viceversa).
         response.sendRedirect("index.jsp"); 
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
