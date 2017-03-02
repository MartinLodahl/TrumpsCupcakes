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

        <script
            src="https://code.jquery.com/jquery-3.1.1.js"
            integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
        crossorigin="anonymous"></script>
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
                        i += 1;
                        out.println("<tr> "
                                + "<td>" + bot.getTaste() + "</td>"
                                + "<td>" + bot.getPrice() + "</td>");
                        out.println("<td><input type=\"radio\" name=\"bot\" id=\"bot" + i + "\" value=\"" + bot.getPrice() + "/" + bot.getTaste() + "\" ></td>");
                    }
                    out.println("<td><input type=\"hidden\" name=\"bot\" id=\"bot0\" value=\"" + listBot.size() + "\" ></td>");

                    out.println("<td><input type=\"hidden\" name=\"money\" id=\""+(session.getAttribute("monitos"))+"\" ></td>");
                %>


            </table> 
            <table>    
                <tr>
                    <th>Taste</th>
                    <th>Price</th>
                    <th>Choose</th>
                </tr>    

                <h2> Tops </h2>
                <%                    // retrieve your list from the request, with casting 
                    tbm = new TopBottomMapper();
                    List<Top> listTop = tbm.getTop();
                    int j = 0;
                    for (Top top : listTop) {
                        j++;
                        out.println("<tr> "
                                + "<td>" + top.getTaste() + "</td>"
                                + "<td>" + top.getPrice() + "</td>");
                        out.println("<td><input type=\"radio\" id=\"top" + j + "\" name=\"top\" value=\"" + top.getPrice() + "/" + top.getTaste() + "\"></td>");
                    }
                    out.println("<td><input type=\"hidden\" name=\"top\" id=\"top0\" value=\"" + listTop.size() + "\" ></td>");
                %>

            </table> 
            <input type="number" name="quantity" value ="1" id="quantity">
            <input type="submit" name="origin" value="order">
        </form>

        <script>

            function calculatePrice(p1, p2, quantity) {
                var price = (p1 + p2) * quantity;


                return price;
            }

            var bL = $('input[id="bot0"]').val();
            for (var i = 0; i <= bL; i++) {
                document.getElementById("bot" + i).addEventListener('click', run);
            }
            var tL = $('input[id="top0"]').val();

            for (var j = 0; j <= tL; j++) {
                document.getElementById("top" + j).addEventListener('click', run);
            }
            document.getElementById("quantity").addEventListener('click', run);


            function run() {

                var p1;
                var p2;
                var quantity;

                var valueBot = $('input[name="bot"]:checked').val();
                var valueTop = $('input[name="top"]:checked').val();
                quantity = $('input[id="quantity"]').val();



                p1 = valueBot.substring(0, 1);
                p2 = valueTop.substring(0, 1);


                p1 = parseInt(p1);
                p2 = parseInt(p2);
                quantity = parseInt(quantity);
                document.getElementById("per").innerHTML = "Price: " + calculatePrice(p1, p2, quantity);
            }


        </script>
    </body>
</html>


