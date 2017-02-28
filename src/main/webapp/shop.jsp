<%-- 
    Document   : shop
    Created on : 28-02-2017, 13:20:56
    Author     : MartinLodahl
--%>


<%@page import="domain.entity.Top"%>
<%@page import="data.TopBottomMapper"%>
<%@page import="java.util.List"%>
<%@page import="domain.entity.Bot"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello You're now in the shop!</h1>
        <form action="Control" method="POST">
            <table>    
                <tr>
                    <th>Taste</th>
                    <th>Price</th>
                    <th>Choose</th>
                </tr>    

                <h2> Bots </h2>
                <%
                    // retrieve your list from the request, with casting 
                    TopBottomMapper tbm = new TopBottomMapper();
                    List<Bot> listBot = tbm.getBot();
                    for (Bot bot : listBot) {
                        out.println("<tr> "
                                + "<td>" + bot.getTaste() + "</td>"
                                + "<td>" + bot.getPrice() + "</td>");
                        out.println("<td><input type=\"radio\" name=\"bot\" value=\"" + bot.getTaste() + "\"></td>");
                    }
                %>


            </table> 
            <table>    
                <tr>
                    <th>Taste</th>
                    <th>Price</th>
                    <th>Choose</th>
                </tr>    

                <h2> Tops </h2>
                <%
                    // retrieve your list from the request, with casting 
                    tbm = new TopBottomMapper();
                    List<Top> listTop = tbm.getTop();
                    for (Top top : listTop) {
                        out.println("<tr> "
                                + "<td>" + top.getTaste() + "</td>"
                                + "<td>" + top.getPrice() + "</td>");
                        out.println("<td><input type=\"radio\" name=\"top\" value=\"" + top.getTaste() + "\"></td>");
                    }
                %>

            </table> 
            <input type="submit" name="origin" value="order">
        </form>

    </body>
</html>
