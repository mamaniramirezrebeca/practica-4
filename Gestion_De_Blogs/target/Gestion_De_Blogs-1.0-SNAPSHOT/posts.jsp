<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Post"%>
<%
    List<Post> posts = (List<Post>)request.getAttribute("posts");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Blog De Tecnologia</h1>
        <p><a href="PostController?action=add">Nuevo</a></p>
        <table border="1">

            <tr>
                <th>Id</th>
                <th>Fecha</th>
                <th>Titulo</th>
                <th>Contenido</th>
                <th></th>
                <th></th>
            </tr>

            <c:forEach var="item" items="${posts}">

                <tr>
                    <td>${item.id}</td>
                    <td>${item.fecha}</td>
                    <td>${item.titulo}</td>
                    <td>${item.contenido}</td>
                    <td><a href="PostController?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="PostController?action=delete&id=${item.id}">Eliminar</a></td>
                </tr>

            </c:forEach>
        </table>
    </body>
</html>
