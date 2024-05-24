<%@page import="com.emergentes.modelo.Post"%>
<%
    Post post = (Post)request.getAttribute("post");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo entrada</h1>
        <form action="PostController" method="post">
            <input type="hidden" name="id" value="${post.id}" />
            <table>
                <tr>
                    <td>Fecha</td>
                    <td><input type="Date" name="fecha" value="${post.fecha}" /></td>
                </tr>
                <tr>
                    <td>Titulo</td>
                    <td><input type="text" name="titulo" value="${post.titulo}" /></td>
                </tr>
                <tr>
                    <td>Contenido</td>
                    <td>
                        <textarea name="contenido" rows="3" cols="50">${post.contenido}</textarea>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
