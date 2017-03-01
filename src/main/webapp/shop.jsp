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
        <div style="float: right;">
            <a>Your balance: <%=((session.getAttribute("monitos") == null) ? "" : session.getAttribute("monitos"))%></</a>
            <p id="per" >Price should happen</p>
        </div> 

        <form action="Control" method="POST" name="cake">
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
                    int i = 0;
                    for (Bot bot : listBot) {
                        i +=1;
                        out.println("<tr> "
                                + "<td>" + bot.getTaste() + "</td>"
                                + "<td>" + bot.getPrice() + "</td>");
                        out.println("<td><input type=\"radio\" name=\"bot\" id=\"bot"+i+"\" value=\""/* +bot.getPrice()+"/"*/ + bot.getTaste() + "\" ></td>");
                        
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
                        out.println("<td><input type=\"radio\" id=\"" + top.getPrice() + "\" name=\"top\" value=\""/*+top.getPrice()+"/"*/ + top.getTaste() + "\"></td>");
                    }
                %>

            </table> 
            <input type="number" name="quantity" value ="1">
            <input type="submit" name="origin" value="order">
        </form>

        <script>
            document.getElementById("per").innerHTML = calculatePrice(1, 2);
            function calculatePrice(p1, p2) {
                var price = p1 + p2;
                alert(price);

                return price;
            }


            document.getElementById("bot1").addEventListener('click', run);
            
            alert(34233);
            
            function run() {
                alert(0);
                var p1;
                var p2;
                alert(1);
               var valueBot = $('input[name="bot"]:checked').val();
               alert(valueBot);
                var radios = document.getElementsByName('bot');
                alert(2);
                for (var i = 0, length = radios.length; i < length; i++) {
                    if (radios[i].checked) {
                        // do whatever you want with the checked radio
                        p1 = radios[i].id;
                        alert(p1);
                    }
                }
                alert(3);
                $('input[name="top"]:checked').val();
                var radios = document.getElementsByName('top');
                for (var i = 0, length = radios.length; i < length; i++) {
                    if (radios[i].checked) {
                        // do whatever you want with the checked radio
                        p2 = radios[i].id;
                        alert(p2);
                    }
                }
                document.getElementById("per").innerHTML = calculatePrice(p1, p2);
            }


        </script>
    </body>
</html>


