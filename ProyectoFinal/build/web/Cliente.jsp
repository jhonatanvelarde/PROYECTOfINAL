<%-- 
    Document   : Cliente
    Created on : 29-jun-2021, 11:25:53
    Author     : hye
--%>

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
                <form action="Controlador?menu=Cliente" method="post">
                    
                    <div class="form-group" >
                        <laber> Dni</laber>
                        <input type="text"  value="${cliente.getDni()}" name="txtDni" class="form-control">
                    </div>
                    <div  class="form-group"> 
                    <laber> Nombre</laber>
                        <input type="text" value="${cliente.getNom()}"name="txtNombres" class="form-control">
                    </div>
                    
                    <div  class="form-group">  
                    <laber> Direccion</laber>
                        <input type="text" value="${cliente.getDir()}"name="txtDir" class="form-control">
                    </div>
                    <div  class="form-group"> 
                    <laber> Estado</laber>
                        <input type="text" value="${cliente.getEstado()}"name="txtEstado" class="form-control">
                    </div> 
                    <div  class="form-group">  
                  
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
                        <th>Direccion</th>
                        <th>Estado</th>
                        
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="c" items="${clientes}"> 
                <tr >
                        <td>${c.getId()}</td>
                        <td>${c.getDni()}</td>
                        <td>${c.getNom()}</td>
                        <td>${c.getDir()}</td>
                        <td>${c.getEstado()}</td>
                         <td>
                        <a class="btn btn-warning" href="Controlador?menu=Cliente&accion=Editar&id=${c.getId()}">Editar </a>
                        <a class="btn btn-danger" href="Controlador?menu=Cliente&accion=Delete&id=${c.getId()}">Eliminar </a>
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
</html>
