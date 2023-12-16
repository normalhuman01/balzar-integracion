/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.Controlador;

import com.proy.ingweb.DAO.ClienteDAO;
import com.proy.ingweb.DAO.MedicamentoDAO;
import com.proy.ingweb.DAO.OperarioDAO;
import com.proy.ingweb.DAO.ProveedorDAO;
import com.proy.ingweb.iDAO.IProveedorDAO;
import java.io.IOException;
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
@WebServlet(name = "MenuController", urlPatterns = {"/MenuController"})
public class MenuController extends HttpServlet {

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
        //Menu de la barra superior
        String menu = request.getParameter("menu");
        switch (menu) {
            case "Principal":
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
                break;
            case "Clientes":
                ClienteDAO cli_metodos = new ClienteDAO();
                List lista_clientes = cli_metodos.listar();
                request.setAttribute("lista_clientes", lista_clientes);
                System.out.println(lista_clientes);
                request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                break;
            case "Proveedores":
                IProveedorDAO pro_metodos = new ProveedorDAO();
                List lista_proveedores = pro_metodos.listar();
                request.setAttribute("lista_proveedores", lista_proveedores);
                System.out.println(lista_proveedores);
                request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
                break;
            case "Medicamentos":
                MedicamentoDAO med_metodos = new MedicamentoDAO();
                List lista_medicamentos = med_metodos.listar();
                request.setAttribute("lista_medicamentos", lista_medicamentos);
                request.getRequestDispatcher("Medicamentos.jsp").forward(request, response);
                break;
            case "Operarios":
                OperarioDAO oper_metodos = new OperarioDAO();
                List lista = oper_metodos.listar();
                request.setAttribute("operarios", lista);
                request.getRequestDispatcher("Operarios.jsp").forward(request, response);
                break;
            case "NuevaVenta":
                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                break;
            case "Backup":
                request.getRequestDispatcher("Backup.jsp").forward(request, response);
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
