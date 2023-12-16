/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.Controlador;

import com.proy.ingweb.DAO.ClienteDAO;
import com.proy.ingweb.DAO.MedicamentoDAO;
import com.proy.ingweb.DAO.VentasDAO;
import com.proy.ingweb.Modelo.Cliente;
import com.proy.ingweb.Modelo.GenerarSerie;
import com.proy.ingweb.Modelo.Medicamento;
import com.proy.ingweb.Modelo.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "VentaController", urlPatterns = {"/VentaController"})
public class VentaController extends HttpServlet {

    ClienteDAO cli_metodos = new ClienteDAO();
    Cliente cli = new Cliente();
    Medicamento med = new Medicamento();
    MedicamentoDAO med_metodos = new MedicamentoDAO();
    //String dni;
    //String idMedicamento;

    Venta venta = new Venta();
    List<Venta> lista_venta = new ArrayList<>();
    int item;
    String codigo;
    String NombreMedicamento;
    float precio;
    int cantidad;
    float subtotal;
    float TotalAPagar;

    String numeroserie;
    VentasDAO ventas_metodos = new VentasDAO();

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
            case "BuscarCliente":
                String dni = request.getParameter("txtDni");
                cli = cli_metodos.listarDNI(dni);
                request.setAttribute("medicamento", med);
                request.setAttribute("lista", lista_venta);
                request.setAttribute("cliente", cli);
                GenerarNumeroSerie(request, response);
                request.getRequestDispatcher("MenuController?menu=NuevaVenta").forward(request, response);
                break;
            case "BuscarMedicamento":
                String idMedicamento = request.getParameter("txtIdMedicamento");
                med = med_metodos.listarId(idMedicamento);
                request.setAttribute("medicamento", med);
                request.setAttribute("lista", lista_venta);
                request.setAttribute("TotalAPagar", TotalAPagar);
                request.setAttribute("cliente", cli);
                GenerarNumeroSerie(request, response);
                request.getRequestDispatcher("MenuController?menu=NuevaVenta").forward(request, response);
                break;

            case "AgregarCarrito":
                item = item + 1;
                codigo = request.getParameter("txtCodigo");
                //System.out.println("HOLA");
                //System.out.println(codigo);
                NombreMedicamento = request.getParameter("txtNomMedicamento");
                precio = Float.parseFloat(request.getParameter("txtPrecio"));
                cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                subtotal = precio * cantidad;
                venta = new Venta();
                venta.setItem(item);
                venta.setIdMedicamento(codigo);
                venta.setNombreMedicamento(NombreMedicamento);
                venta.setPrecio(precio);
                venta.setCantidad(cantidad);
                venta.setSubTotal(subtotal);
                lista_venta.add(venta);
                for (int i = 0; i < lista_venta.size(); i++) {
                    TotalAPagar = TotalAPagar + lista_venta.get(i).getSubTotal();
                }
                //System.out.println(TotalAPagar);
                request.setAttribute("TotalAPagar", TotalAPagar);
                request.setAttribute("lista", lista_venta);
                request.setAttribute("cliente", cli);
                GenerarNumeroSerie(request, response);
                request.getRequestDispatcher("MenuController?menu=NuevaVenta").forward(request, response);
                break;

            case "GenerarVenta":
                //Actualizar Stock
                for (int i = 0; i < lista_venta.size(); i++) {
                    Medicamento mgv = new Medicamento();
                    int gvcantidad=lista_venta.get(i).getCantidad();
                    String gvIdMedicamento = lista_venta.get(i).getIdMedicamento();
                    MedicamentoDAO mgv_metodos = new MedicamentoDAO();
                    mgv=mgv_metodos.listarId(gvIdMedicamento);
                    int stock_actual = mgv.getStock()-gvcantidad;
                    mgv_metodos.actualizarStock(gvIdMedicamento, stock_actual);
                    
                }
                    
                //GUARDAR VENTA
                venta.setIdCliente(cli.getIdCliente());
                venta.setIdOperario(4);
                venta.setNumSerie(numeroserie);
                venta.setFechaVenta("2020-09-25");
                venta.setMonto(TotalAPagar);
                venta.setEstado("1");
                //System.out.println("\n\nCLi"+venta.getIdCliente()+"\n"+"NS"+venta.getNumSerie()+"\n"+venta.getMonto());
                ventas_metodos.guardarVenta(venta);
                //Guardar Detalle Ventas
                int idv = Integer.parseInt(ventas_metodos.IdVentas());
                for (int i = 0; i < lista_venta.size(); i++) {
                    venta = new Venta();
                    venta.setIdVentas(idv);
                    venta.setIdMedicamento(lista_venta.get(i).getIdMedicamento());
                    venta.setCantidad(lista_venta.get(i).getCantidad());
                    venta.setPrecio(lista_venta.get(i).getPrecio());
                    ventas_metodos.guardarDetalleVentas(venta);
                }
                break;

            case "Eliminar":
                break;

            default:

                request.getRequestDispatcher("MenuController?menu=NuevaVenta").forward(request, response);
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

    public void GenerarNumeroSerie(HttpServletRequest request, HttpServletResponse response) {
        //System.out.println("AAAA");
        numeroserie = ventas_metodos.GenerarSerie();
        if (numeroserie == null) {
            numeroserie = "00000001";
            request.setAttribute("NumSerie", numeroserie);
        } else {
            int incrementar = Integer.parseInt(numeroserie);
            GenerarSerie gs = new GenerarSerie();
            numeroserie = gs.NumeroSerie(incrementar);
            request.setAttribute("NumSerie", numeroserie);
        }
    }
}
