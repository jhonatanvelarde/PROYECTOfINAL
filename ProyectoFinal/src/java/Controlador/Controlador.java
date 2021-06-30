/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAo;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Vendedor;
import Modelo.VendedorDAO;
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
 * @author hye
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

  Vendedor em=new Vendedor();
  VendedorDAO edao=new VendedorDAO();
  Cliente c=new Cliente();
  ClienteDAo cdao=new ClienteDAo();
  Producto p=new Producto();
  ProductoDAO pdao=new ProductoDAO();
  int ide;
  int idc;
  int idp;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             String menu=request.getParameter("menu");
        String accion=request.getParameter("accion");
        if(menu.equals("Principal")){
        request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if(menu.equals("Vendedor")){
            switch (accion){
                case "Listar":
                    List lista=edao.listar();
                    request.setAttribute("vendedores",lista);
                    break;
                     case "Agregar":
                         String dni=request.getParameter("txtDni");
                          String nom=request.getParameter("txtNombres");
                         String tel=request.getParameter("txtTel");
                          String est=request.getParameter("txtEstado");
                           String user=request.getParameter("txtUser");
                                         em.setDni(dni);
                                         em.setNom(nom);
                                         em.setTel(tel);
                                         em.setEstado(est);
                                         em.setUser(user);
                                         
                                         edao.agregar(em);
                                         request.getRequestDispatcher("Controlador?menu=Vendedor&accion=Listar").forward(request, response);
                    break;
                          case "Editar":
                              ide=Integer.parseInt(request.getParameter("id"));
                              Vendedor e =edao.listarId(ide);
                              request.setAttribute("vendedor",e);
                               request.getRequestDispatcher("Controlador?menu=Vendedor&accion=Listar").forward(request, response);
                    break;
                               case "Actualizar":
                                   String dni1=request.getParameter("txtDni");
                                   String nom1=request.getParameter("txtNombres");
                                   String tel1=request.getParameter("txtTel");
                                   String est1=request.getParameter("txtEstados");
                                   String user1=request.getParameter("txtUser");
                                   em.setDni(dni1);
                                   em.setNom(nom1);
                                   em.setTel(tel1);
                                   em.setEstado(est1);
                                   em.setUser(user1);
                                   em.setId(ide);
                                   edao.actualizar(em);
                                   request.getRequestDispatcher("Controlador?menu=Vendedor&accion=Listar").forward(request, response);
                                   
                    break;
                               case "Delete":
                                   ide=Integer.parseInt(request.getParameter("id"));
                                   edao.delete(ide);
                                    request.getRequestDispatcher("Controlador?menu=Vendedor&accion=Listar").forward(request, response);
                                   break;
                default:
                    throw new AssertionError();
            }
        request.getRequestDispatcher("Vendedor.jsp").forward(request, response);
        }
        
        
        
         if(menu.equals("Cliente")){
                         switch (accion){
                case "Listar":
                    List lista=cdao.listar();
                    request.setAttribute("clientes",lista);
                    break;
                     case "Agregar":
                         String dni=request.getParameter("txtDni");
                          String nom=request.getParameter("txtNombres");
                         String dir=request.getParameter("txtDireccion");
                          String est=request.getParameter("txtEstado");
                                         c.setDni(dni);
                                         c.setNom(nom);
                                         c.setDir(dir);
                                         c.setEstado(est);
                                         
                                        cdao.agregar(c);
                                         request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                          case "Editar":
                              idc=Integer.parseInt(request.getParameter("id"));
                              Cliente e =cdao.listarId(idc);
                              request.setAttribute("cliente",e);
                               request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                               case "Actualizar":
                                   String dni1=request.getParameter("txtDni");
                                   String nom1=request.getParameter("txtNombres");
                                   String dir1=request.getParameter("txtDireccion");
                                   String est1=request.getParameter("txtEstados");
                                   c.setDni(dni1);
                                   c.setNom(nom1);
                                   c.setDir(dir1);
                                   c.setEstado(est1);
                                   c.setId(idc);
                                   cdao.actualizar(c);
                                   request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                                   
                    break;
                               case "Delete":
                                   idc=Integer.parseInt(request.getParameter("id"));
                                   cdao.delete(idc);
                                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                                   break;
                default:
                    throw new AssertionError();
            }
        request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        }
         
         
         
         
         
          if(menu.equals("Producto")){
        request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
          
          
           if(menu.equals("NuevaVenta")){
               switch(accion){
                   case "BuscarCliente":
                       String dni=request.getParameter("codigocliente");
                       c.setDni(dni);
                       c= cdao.buscar(dni);
                       request.setAttribute("c",c);
                       break;
                   case "BuscarProducto":
                       int id=Integer.parseInt(request.getParameter("codigoproducto"));
                      p=  pdao.listarID(id);
                       request.setAttribute("producto",p);
                   default:
                       throw new AssertionError();
               }
        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


}
