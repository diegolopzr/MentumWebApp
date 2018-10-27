/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import datos.ContactoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Contacto;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "controladorContacto", urlPatterns = {"/controladorContacto"})
public class controladorContacto extends HttpServlet {

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
            Contacto _c = new Contacto();
            ContactoDAO daoContacto = new ContactoDAO();
            int buscarClienteId = 0;
            buscarClienteId = daoContacto.buscarClienteId(request.getParameter("nom_clientescontacto"));
            if (buscarClienteId != 0) {
                _c.setCliente(buscarClienteId);
            }
            if (!request.getParameter("nombre_Contacto").equals("")) {
                _c.setNombre(request.getParameter("nombre_Contacto"));
            }
            if (!request.getParameter("direccion_Contacto").equals("")) {
                _c.setDireccion(request.getParameter("direccion_Contacto"));
            }
            if (!request.getParameter("telefono_Contacto").equals("")) {
                _c.setTelefono(request.getParameter("telefono_Contacto"));
            }
            
            int cantidad = daoContacto.crear(_c);
            out.print(cantidad);
            if (cantidad  == 1)
                response.sendRedirect( "views/web_mensaje.jsp?mensaje="+_c.getNombre()+" fue agregado con Exito" );
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
