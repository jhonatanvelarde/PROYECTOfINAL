<%-- 
    Document   : Vendedor
    Created on : 29-jun-2021, 11:25:37
    Author     : hye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
          <div class="card col-sm-4 " >
            <div class="card-body">
                <form action="Controlador?menu=Vendedor" method="post">
                    
                    <div class="form-group" >
                        <laber> Dni</laber>
                        <input type="text"  value="${vendedor.getDni()}" name="txtDni" class="form-control">
                    </div>
                    <div  class="form-group"> 
                    <laber> Nombre</laber>
                        <input type="text" value="${vendedor.getNom()}"name="txtNombres" class="form-control">
                    </div>
                    
                    <div  class="form-group">  
                    <laber> Telefono</laber>
                        <input type="text" value="${vendedor.getTel()}"name="txtTel" class="form-control">
                    </div>
                    <div  class="form-group"> 
                    <laber> Estado</laber>
                        <input type="text" value="${vendedor.getEstado()}"name="txtEstado" class="form-control">
                    </div> 
                    <div  class="form-group">  
                    <laber> Usuario</laber>
                        <input type="text" value="${vendedor.getUser()}"name="txtUser" class="form-control">
                    </div>
                    <input type="submit" name="accion" value="Agregar" class="btn btn-info" >
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-info" >
                      
                </form>
             </div>
        </div>
        <div class="col-sm-8">
            <table class="table table-hover">
                <thead>
                    <tr>
                         <th>Id</th>
                        <th>Dni</th>
                        <th>Nombre</th>
                        <th>Telefono</th>
                        <th>Estado</th>
                        <th>Usuario</th>
                          <th>Acciones</th>
                        
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="em" items="${vendedores}"> 
                <tr >
                        <td>${em.getId()}</td>
                        <td>${em.getDni()}</td>
                        <td>${em.getNom()}</td>
                        <td>${em.getTel()}</td>
                        <td>${em.getEstado()}</td>
                        <td>${em.getUser()}</td>
                         <td>
                        <a class="btn btn-warning" href="Controlador?menu=Vendedor&accion=Editar&id=${em.getId()}">Editar </a>
                        <a class="btn btn-danger" href="Controlador?menu=Vendedor&accion=Delete&id=${em.getId()}">Eliminar </a>
                    </td>
                    </tr>
                   
                </c:forEach>
                    
                </tbody>
            </table>
        </div>   
        </div>
       
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
    </body>
</html>
