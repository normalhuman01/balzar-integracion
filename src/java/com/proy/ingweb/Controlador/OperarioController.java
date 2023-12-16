/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.Controlador;

import com.proy.ingweb.DAO.OperarioDAO;
import com.proy.ingweb.Modelo.Operario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TicowST
 */
@WebServlet(name = "OperarioController", urlPatterns = {"/OperarioController"})
public class OperarioController extends HttpServlet {
    
    Operario oper= new Operario();
    OperarioDAO oper_metodos = new OperarioDAO();
    int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        
        switch(accion){
            case "Listar":
                break;
            case "Agregar":
                //Se obtienen los datos de la pagina
                String Dni = request.getParameter("txtDni");
                String Nombres = request.getParameter("txtNombres");
                String Direccion = request.getParameter("txtDireccion");
                String Telefono = request.getParameter("txtTelefono");
                String Usuario = request.getParameter("txtUsuario");
                String Rol = request.getParameter("txtRol");
                        
                //Asignamos a un objeto de operario
                oper.setDni(Dni);
                oper.setNombres(Nombres);
                oper.setDireccion(Direccion);
                oper.setTelefono(Telefono);
                oper.setRol(Rol);
                oper.setUsuario(Usuario);
                oper.setPassw(Usuario);
                
                oper_metodos.agregar(oper);
                request.getRequestDispatcher("MenuController?menu=Operarios").forward(request, response);
               break;
                
            case "Editar":
                id= Integer.parseInt(request.getParameter("id"));
                oper = oper_metodos.listarId(id);
                request.setAttribute("operario", oper);
                request.getRequestDispatcher("MenuController?menu=Operarios").forward(request, response);
                break;
            
            case "Actualizar":
                //Obtener los datos de la vista
                String aDni = request.getParameter("txtDni");
                String aNombres = request.getParameter("txtNombres");
                String aDireccion = request.getParameter("txtDireccion");
                String aTelefono = request.getParameter("txtTelefono");
                String aUsuario = request.getParameter("txtUsuario");
                String aRol = request.getParameter("txtRol");
                String aPassw = request.getParameter("txtPassw");
                oper.setIdOperario(id);
                oper.setDni(aDni);
                oper.setNombres(aNombres);
                oper.setDireccion(aDireccion);
                oper.setTelefono(aTelefono);
                oper.setRol(aRol);
                oper.setUsuario(aUsuario);
                oper.setPassw(aPassw);
                System.out.println(aPassw);
                oper_metodos.actualizar(oper);
                request.getRequestDispatcher("MenuController?menu=Operarios").forward(request, response);

                break;
                
            case "Eliminar":
                id=Integer.parseInt(request.getParameter("id"));
                oper_metodos.eliminar(id);
                request.getRequestDispatcher("MenuController?menu=Operarios").forward(request, response);
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
