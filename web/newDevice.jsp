<%-- 
    Document   : newDevice
    Created on : 28/08/2019, 04:13:22 PM
    Author     : aidee
--%>
<%@page import="Model.GestorBD"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" pageEncoding="EUC-KR">

        <title>New divice</title>
        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="<%= request.getContextPath()%>/css/bootstrap.min.css"/>

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/font-awesome.min.css">

    </head>
    
    <%
      GestorBD getID = new GestorBD();
      int id = getID.getID(); //Lo obtengo para saber que ID autoincrementable sigue.
    %>
    
    <body>
        <div class="container">
            <div class="col-md-12 order-md-1-1 ">
                <h4 class="mb-3">Nuevo dispositivo</h4>
                <hr>
                <form action="addDevice" method="post">
                    <div class="row">
                        <div class="col-md-3 mb-3">
                            <label for="nombre">ID: </label>
                            <input type="text" class="form-control" name="id" placeholder="" 
                                   value="<%= id %>" required readonly>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="nombre">Nombre: </label>
                            <input type="text" class="form-control" name="nombre" placeholder="" value="" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="modelo">Modelo: </label>
                            <input type="text" class="form-control" name="modelo" placeholder="" value="" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="marca">Marca: </label>
                            <input type="text" class="form-control" name="marca" placeholder="" value="" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="precio">Precio: </label>
                            <input type="number" class="form-control" name="precio" placeholder="123.45" value="" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="country">Color:</label>
                            <select class="form-control"  name="color" required>
                                <option value="ninguno">Elige...</option>
                                <option value="blanco">Blanco</option>
                                <option value="negro">Negro</option>
                                <option value="rojo">Rojo</option>
                                <option value="azul">Azul</option>
                                <option value="plata">Plata</option>
                            </select>
                        </div>
                        <div class="col-md-12 mb-3">
                            <label for="decripcion">Descripción:</label>
                            <textarea class="form-control" rows="5" name="descripcion"></textarea>
                        </div>
                        <br><br>
                        <div class="col-md-3 mb-3">
                            <input class="btn btn-primary" type="submit" value="Guardar" />
                            </form>
                        </div>
                    </div>
            </div>
        </div>
    </body>
</html>
