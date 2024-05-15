package com.emergentes.controlador;

import com.emergentes.dao.RegistroDAO;
import com.emergentes.dao.RegistroDAOinpl;
import com.emergentes.modelo.Registro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistroControl", urlPatterns = {"/RegistroControl"})
public class RegistroControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Registro reg = new Registro();
        int id;
        RegistroDAO dao = new RegistroDAOinpl();
        String action = request.getParameter("action" != null ? request.getParameter("action") : "view");
        switch (action) {
            case "add":
                request.setAttribute("registro", reg);
                request.getRequestDispatcher("formulario.jsp").forward(request, response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("Id"));
                 {
                    try {
                        reg = dao.getById(id);
                    } catch (Exception ex) {
                        System.out.println("Error al obtenre registro"+ ex.getMessage());
                    }
                }
                request.setAttribute("Registro", reg);

                request.getRequestDispatcher("Fraregistro.jsp").forward(request, response);
                break;

            case "delete":
               id = Integer.parseInt(request.getParameter("Id"));
            {
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("Error al Eliminar: " + ex.getMessage());
                }
            }
               response.sendRedirect("RegistroControl");
                break;

            case "view":
               List <Registro> lista = new ArrayList<Registro>();
            {
                try {
                   lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("Error en la lista :"+ ex.getMessage());
                }
            }
                request.setAttribute("registro", lista);
                request.getRequestDispatcher("registro.jsp").forward(request, response);
                
                break;

            default:
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
