/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.Controlador;

import com.proy.ingweb.DAO.ClienteDAO;
import com.proy.ingweb.Modelo.Cliente;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author TicowST
 */
@WebServlet(name = "ClienteController", urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {

    Cliente cli = new Cliente();
    ClienteDAO cli_metodos = new ClienteDAO();
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        switch (accion) {
            case "Listar":
                break;
            case "Agregar":
                //Se obtienen los datos de la pagina
                String Dni = request.getParameter("txtDni");
                String ApellidoPaterno = request.getParameter("txtApellidoPaterno");
                String ApellidoMaterno = request.getParameter("txtApellidoMaterno");
                String Nombres = request.getParameter("txtNombres");
                String Direccion = request.getParameter("txtDireccion");
                String Telefono = request.getParameter("txtTelefono");
                int Edad = Integer.parseInt(request.getParameter("txtEdad"));
                DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate FechaNacimiento = LocalDate.parse(request.getParameter("txtFechaNacimiento"), f);

                //Asignamos a un objeto de operario
                cli.setDni(Dni);
                cli.setApellidoPaterno(ApellidoPaterno);
                cli.setApellidoMaterno(ApellidoMaterno);
                cli.setNombres(Nombres);
                cli.setDireccion(Direccion);
                cli.setTelefono(Telefono);
                cli.setFechaNacimiento(FechaNacimiento);
                cli.setEdad(Edad);

                System.out.println(cli);

                int r = cli_metodos.agregar(cli);
                System.out.println(r);
                request.getRequestDispatcher("MenuController?menu=Clientes").forward(request, response);
                break;

            case "Editar":
                id = Integer.parseInt(request.getParameter("id"));
                cli = cli_metodos.listarId(id);
                request.setAttribute("cliente", cli);
                request.getRequestDispatcher("MenuController?menu=Clientes").forward(request, response);
                break;

            case "Actualizar":
                //Obtener los datos de la vista
                String aDni = request.getParameter("txtDni");
                String aApellidoPaterno = request.getParameter("txtApellidoPaterno");
                String aApellidoMaterno = request.getParameter("txtApellidoMaterno");
                String aNombres = request.getParameter("txtNombres");
                String aDireccion = request.getParameter("txtDireccion");
                String aTelefono = request.getParameter("txtTelefono");
                DateTimeFormatter af = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate aFechaNacimiento = LocalDate.parse(request.getParameter("txtFechaNacimiento"), af);
                cli.setDni(aDni);
                cli.setApellidoPaterno(aApellidoPaterno);
                cli.setApellidoMaterno(aApellidoMaterno);
                cli.setNombres(aNombres);
                cli.setDireccion(aDireccion);
                cli.setTelefono(aTelefono);
                cli.setFechaNacimiento(aFechaNacimiento);
                cli.setEdad(aFechaNacimiento.getYear());

                cli_metodos.actualizar(cli);
                request.getRequestDispatcher("MenuController?menu=Clientes").forward(request, response);

                break;

            case "Eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                System.out.println(id);
                cli_metodos.eliminar(id);
                request.getRequestDispatcher("MenuController?menu=Clientes").forward(request, response);
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
