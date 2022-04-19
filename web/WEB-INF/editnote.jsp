<%-- 
    Document   : editnote
    Created on : 7-Apr-2022, 2:03:54 PM
    Author     : Raj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper - Edit</title>
    </head>
    <body>
        
        <h1>Simple Note Keeper</h1>
         <h2>Edit Note</h2>

            <form action="note" method="post">   
                Title: <input type="text" name="title" value="${note.title}"><br>
                Contents: <textarea name="contents">${note.content}</textarea><br>
                <input type="submit" name="save" value="Save">  
            </form>
     
    </body>
</html>
