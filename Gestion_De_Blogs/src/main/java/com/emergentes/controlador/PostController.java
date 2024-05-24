package com.emergentes.controlador;

import com.emergentes.dao.PostDAO;
import com.emergentes.dao.PostDAO_impl;
import com.emergentes.modelo.Post;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PostController", urlPatterns = {"/PostController"})
public class PostController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PostDAO dao = new PostDAO_impl();
        Post post = new Post();
        int id;

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("post", post);
                request.getRequestDispatcher("frmpost.jsp").forward(request, response);
                break;
            case "edit":
                // AvisoController?action=edit&id=3
                id = Integer.parseInt(request.getParameter("id"));

                try {
                    // obtener el objeto que corresponde al registro
                    post = dao.getById(id);
                } catch (Exception ex) {
                    System.out.println("Error al obtener el registro: "+ ex.getMessage());
                }

                // Colocar como atributo
                request.setAttribute("post", post);
                // Transferir el control a frmaviso.jsp
                request.getRequestDispatcher("frmpost.jsp").forward(request, response);
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
            
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("Error al eliminar el registro: "+ ex.getMessage());
                }
            
                response.sendRedirect("PostController");
                break;


            case "view":
                List<Post> lista = new ArrayList<Post>();
            
                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("Error al listar: "+ ex.getMessage());
                }
            
                request.setAttribute("posts", lista);
                request.getRequestDispatcher("posts.jsp").forward(request, response);
                break;

            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Date fecha = Date.valueOf(request.getParameter("fecha"));
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        
        Post post = new Post();
        
        post.setId(id);
        post.setFecha(fecha);
        post.setTitulo(titulo);
        post.setContenido(contenido);
        
        PostDAO dao = new PostDAO_impl();
        
        if (id == 0) {
            try {
                dao.insert(post);
            } catch (Exception ex) {
                System.out.println("Error al insertar: "+ ex.getMessage());
            }
        }
        else{
            try {
                dao.update(post);
            } catch (Exception ex) {
                System.out.println("Error al actualizar: "+ ex.getMessage());
            }
        }
        response.sendRedirect("PostController");
        
    }

}
