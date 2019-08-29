<%-- 
    Document   : index
    Created on : 27/08/2019, 08:05:19 PM
    Author     : aidee
--%>

<%@page import="Model.GestorBD"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Dispositivo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" pageEncoding="EUC-KR">

    <title>Index Page</title>
    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="<%= request.getContextPath()%>/css/bootstrap.min.css"/>

    <!-- Font Awesome Icon -->
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/font-awesome.min.css">

    </head>
    <body>
        <div class="container">
            <h1> CRUD - Dispositivos</h1>
            <a class="btn btn-success" href="<%=request.getContextPath()%>/newDevice.jsp"> Agregar</a>
                <br> <br>
                 <%
                Collection<Dispositivo> dispositivo = new ArrayList<>();
                GestorBD gestor = new GestorBD();
                Collection<Dispositivo> disp = null;
                %>
                <table>
                <div class="row">
                         
                        <div class="col-md-4"> 
                            <input type="text" class="form-control" name="txtBuscar" placeholder="Buscar..."/>
                        </div>
                        <div class="col-md-1" align="center"> 
                            <input type="submit" class="form-control" value="buscar"/>
                        </div>
                </div>
            </table>
            <br>
             <%
                String aux = request.getParameter("txtBuscar");
                dispositivo = gestor.getDevs(aux);
                if (aux != null) {
                    disp = dispositivo;
                } else {
                    disp = dispositivo;
                }
            %>
          <!--  <p> Número de disp registrados: <b> <%= disp.size()%> </b></p> -->
            <div class="table-responsive"> 
                <table  cellpadding="5" class="table table-striped table-hover ">
                    <tr>
                        <td> ID </td>
                        <td> Nombre</td>
                        <td> Descripcion</td>
                        <td> Modelo </td>
                        <td> Marca </td>
                        <td> Precio </td>
                        <td> Color</td>
                        <td colspan="2" align="center"> Acciones</td>
                    </tr>
                    
                     <%
                        if (disp.size() == 0) {
                    %>
                    <tr>
                        <td colspan="9" align="center"> Por el momento no hay dispositivos registrados.</td>
                    </tr>
                    <%
                    } else {
                        for (Dispositivo d : disp) {
                    %>
                    <tr>
                        <td><%=d.getId()%></td>
                        <td><%=d.getNombre()%></td>
                        <td><%=d.getDescripcion()%></td>
                        <td><%=d.getModelo()%></td>
                        <td><%=d.getMarca()%></td>
                        <td><%=d.getPrecio()%></td>
                        <td><%=d.getColor()%></td>
                        <td><a href="editDevice.jsp?id=<%= d.getId()%>"> Modificar </a></td>
                        <td><a href="deleteDev?id=<%= d.getId()%>"> Eliminar</a></td>
                    </tr>
                    <%}
                        }%>
                </table>
            </div>
                  <% disp.clear();%>
        </div>
    </body>
</html>
