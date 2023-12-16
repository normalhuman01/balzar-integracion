/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.Controlador;

import com.proy.ingweb.DAO.ClienteDAO;
import com.proy.ingweb.DAO.ProveedorDAO;
import com.proy.ingweb.Modelo.Cliente;
import com.proy.ingweb.Modelo.Proveedor;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luis
 */
@WebServlet(name = "ProveedorController", urlPatterns = {"/ProveedorController"})
public class ProveedorController extends HttpServlet {

 Proveedor pro= new Proveedor();
    ProveedorDAO cli_metodos = new ProveedorDAO();
    int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        switch(accion){
            case "Listar":
                break;
            case "Agregar":
                //Se obtienen los datos de la pagina
                String Ruc = request.getParameter("txtRuc");
                String RazonSocial = request.getParameter("txtRazonSocial");
                String Estado = request.getParameter("txtEstado");
                String Condicion = request.getParameter("txtCondicion");
                String Direccion = request.getParameter("txtDireccion");

    //Asignamos a un objeto de operario
                pro.setRUC(Ruc);
                pro.setRazonSocial(RazonSocial);
                pro.setEstado(Estado);
                pro.setCondicion(Condicion);
                pro.setDireccion(Direccion);

                System.out.println(pro);
                
                int r=cli_metodos.agregar(pro);
                System.out.println(r);
                request.getRequestDispatcher("MenuController?menu=Proveedores").forward(request, response);
               break;
                
            case "Editar":
                id= Integer.parseInt(request.getParameter("id"));
                pro = cli_metodos.listarId(id);
                request.setAttribute("proveedor", pro);
                request.getRequestDispatcher("MenuController?menu=Proveedores").forward(request, response);
                break;
            
            case "Actualizar":
                //Obtener los datos de la vista
                String aRuc = request.getParameter("txtRuc");
                String aRazonSocial = request.getParameter("txtRazonSocial");
                String aEstado = request.getParameter("txtEstado");
                String aCondicion = request.getParameter("txtCondicion");
                String aDireccion = request.getParameter("txtDireccion");
              
                pro.setRUC(aRuc);
                pro.setRazonSocial(aRazonSocial);
                pro.setEstado(aEstado);
                pro.setCondicion(aCondicion);
                pro.setDireccion(aDireccion);
                
                cli_metodos.actualizar(pro);
                request.getRequestDispatcher("MenuController?menu=Proveedores").forward(request, response);

                break;
                
            case "Eliminar":
                id=Integer.parseInt(request.getParameter("id"));
                cli_metodos.eliminar(id);
                request.getRequestDispatcher("MenuController?menu=Proveedores").forward(request, response);
               break;
            
            default:
                throw new AssertionError();
                     
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
