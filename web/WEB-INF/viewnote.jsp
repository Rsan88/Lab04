<%-- 
     Document   : viewnote
    Created on : 7-Apr-2022, 2:03:54 PM
    Author     : Raj
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
   
            <p><b>Title:</b> ${note.getTitle()}<br></p>
            
            <p><b>Contents:</b><br>
            ${note.getContent()}</p>
            <a href="note?edit">Edit</a>
        
    </body>
</html>
