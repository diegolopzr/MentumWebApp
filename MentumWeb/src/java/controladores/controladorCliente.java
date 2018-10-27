/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import datos.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "controladorCliente", urlPatterns = {"/controladorCliente"})
public class controladorCliente extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Cliente _cl = new Cliente();
            ClienteDAO daoCliente = new ClienteDAO();
            if (!request.getParameter("nombre_Cliente").equals("")) {
                _cl.setNombre(request.getParameter("nombre_Cliente"));
            }
            if (!request.getParameter("direccion_Cliente").equals("")) {
                _cl.setDireccion(request.getParameter("direccion_Cliente"));
            }
            if (!request.getParameter("telefono_Cliente").equals("")) {
                _cl.setTelefono(request.getParameter("telefono_Cliente"));
            }
            if (!request.getParameter("fecha_Cliente").equals("")) {
                Date _fechaTemp = _cl.convertirFecha(request.getParameter("fecha_Cliente"));
                _cl.setFecha_creacion(_fechaTemp);
            }
            int cantidad = daoCliente.crear(_cl);
            if (cantidad  == 1)
                response.sendRedirect( "views/web_mensaje.jsp?mensaje="+_cl.getNombre()+" fue agregado con Exito" );
            else 
                response.sendRedirect( "views/web_mensaje.jsp?mensaje= No fue posible agregarlo" );
        } catch (SQLException ex) {
            Logger.getLogger(controladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(controladorCliente.class.getName()).log(Level.SEVERE, null, ex);
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
