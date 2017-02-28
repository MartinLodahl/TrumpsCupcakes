<%-- 
    Document   : shop
    Created on : 28-02-2017, 13:20:56
    Author     : MartinLodahl
--%>


<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello You're now in the shop!</h1>

        <form action="">
            <%
        // retrieve your list from the request, with casting 
                ArrayList<Bots> list = (ArrayList<Bots>) request.getAttribute("Control");

        // print the information about every category of the list
                for (Bots bots : list) {
                    out.println("<input type=\"radio\" name=\""+bots.getName()+"\" value=\"bot\">");
                    out.println(Bots.getName());
                    out.println(category.getMainCategoryId());
                }
            %>
            <input type="radio" name="gender" value="male"> Male<br>
            <input type="radio" name="gender" value="female"> Female<br>
            <input type="radio" name="gender" value="other"> Other
        </form>

    </body>
</html>
