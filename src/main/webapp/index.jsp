<%-- 
    Document   : index
    Created on : 28-02-2017, 12:47:07
    Author     : MartinLodahl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Hello Cupcake Eater!</h1>
       
        <h1> <%=((session.getAttribute("fail")==null)?"":session.getAttribute("fail"))%></h1>
        
        <p>You cupcake killer, login here...</p>
         <form action="Control" method="POST">
            <a>Username</a><input type="text" name="username" /><br>
            <a>Passwor</a><input type="password" name="password" /><br>
            <input type="submit" value="login" name="origin">
        </form>
        
        
        <p>Hey you! Never killed a cupcake before? Start here.</p>
        <form action="Control" method="POST">
            <a>Username</a><input type="text" name="username" /><br>
            <a>Passwor</a><input type="password" name="password" /><br>
            <a>Monitos</a><input type="number" name="monitos" /><br>
            <input type="submit" value="register" name="origin">
        </form>
        
    </body>
</html>
