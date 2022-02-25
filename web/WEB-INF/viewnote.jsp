<%-- 
    Document   : viewnote
    Created on : 24-Feb-2022, 5:57:49 PM
    Author     : Jaren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper - View</title>
    </head>
    <body>
        
        <h1>Simple Note Keeper</h1>
        
        <h2>View Note</h2>
        
        <div>
            <p><b>Title:</b> ${note.title}<br></p>
            
            <p><b>Contents:</b><br>
            ${note.content}</p>
            
            <a href="note?edit">Edit</a>
        </div>
        
    </body>
</html>
