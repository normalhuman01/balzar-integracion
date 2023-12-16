/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.Controlador;

import com.proy.ingweb.DAO.MedicamentoDAO;
import com.proy.ingweb.Modelo.Medicamento;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TicowST
 */
@WebServlet(name = "MedicamentoController", urlPatterns = {"/MedicamentoController"})
public class MedicamentoController extends HttpServlet {

    Medicamento med = new Medicamento();
    MedicamentoDAO med_metodos = new MedicamentoDAO();
    String id;

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
        String accion = request.getParameter("accion");
        switch (accion) {
            case "Listar":
                break;
            case "Agregar":
                //Se obtienen los datos de la pagina
                String IdMedicamento = request.getParameter("txtIdMedicamento");
                String Nombre = request.getParameter("txtNombre");
                String Tipo = request.getParameter("txtTipo");
                float Precio = Float.parseFloat(request.getParameter("txtPrecio"));
                int Stock = Integer.parseInt(request.getParameter("txtStock"));
                String Estado;
                if(Stock > 0){
                    Estado = "1";
                }else{
                    Estado = "0";
                }
                //Asignamos a un objeto de operario
                med.setIdMedicamento(IdMedicamento);
                med.setNombre(Nombre);
                med.setTipo(Tipo);
                med.setPrecio(Precio);
                med.setStock(Stock);
                med.setEstado(Estado);

                int r = med_metodos.agregar(med);
                System.out.println(r);
                request.getRequestDispatcher("MenuController?menu=Medicamentos").forward(request, response);
                break;

            case "Editar":
                id = request.getParameter("id");
                med = med_metodos.listarId(id);
                System.out.println(med.getNombre());

                request.setAttribute("medicamento", med);
                request.getRequestDispatcher("MenuController?menu=Medicamentos").forward(request, response);
                break;

            case "Actualizar":
                //Obtener los datos de la vista
                String aIdMedicamento = request.getParameter("txtIdMedicamento");
                String aNombre = request.getParameter("txtNombre");
                String aTipo = request.getParameter("txtTipo");
                float aPrecio = Float.parseFloat(request.getParameter("txtPrecio"));
                int aStock = Integer.parseInt(request.getParameter("txtStock"));
                String aEstado;
                
                if(aStock > 0 ){
                    aEstado ="1";
                }else{
                    aEstado ="0";
                }
                
                med.setIdMedicamento(aIdMedicamento);
                med.setNombre(aNombre);
                med.setTipo(aTipo);
                med.setPrecio(aPrecio);
                med.setStock(aStock);
                med.setEstado(aEstado);
                
                med_metodos.actualizar(med);
                request.getRequestDispatcher("MenuController?menu=Medicamentos").forward(request, response);

                break;

            case "Eliminar":
                id = request.getParameter("id");
                med_metodos.eliminar(id);
                request.getRequestDispatcher("MenuController?menu=Medicamentos").forward(request, response);
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
