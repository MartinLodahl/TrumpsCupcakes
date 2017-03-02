/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import data.OrderMapper;
import data.TopBottomMapper;
import data.UserMapper;
import domain.entity.Bot;
import domain.entity.Cupcake;
import domain.entity.Top;
import domain.entity.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MartinLodahl
 */
@WebServlet(name = "Control", urlPatterns = {"/Control"})
public class Control extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String origin = request.getParameter("origin");
        UserMapper um = new UserMapper();
        switch (origin) {
            case "register":
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                int monitos = Integer.parseInt(request.getParameter("monitos"));
                User user = new User(username, password, monitos);
                boolean registered = um.createUser(user);
                if (!registered) {
                    request.getSession().setAttribute("fail", "You twat, that user is already in use");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                request.getSession().setAttribute("username", username);
                request.getSession().setAttribute("monitos", monitos);
                startShop(request, response);

                break;
            case "login":
                String usernameLogin = request.getParameter("username");
                String passwordLogin = request.getParameter("password");
                User userLogin = new User(usernameLogin, passwordLogin);
                User loggedIn = um.checkLogin(userLogin);
                if (loggedIn == null) {
                    request.getSession().setAttribute("fail", "You twat, your username or password is wrong");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                request.getSession().setAttribute("username", loggedIn.getUsername());
                request.getSession().setAttribute("monitos", loggedIn.getBalance());
                startShop(request, response);
                break;
            case "order":
                ArrayList<Cupcake> arrayList = new ArrayList<Cupcake>();
                for (int i = 0; i < Integer.parseInt(request.getParameter("k")); i++) {
                    String botI = "bot"+i; 
                    String bot = request.getParameter(botI);
                    String topI = "top"+i;
                    String top = request.getParameter(topI);
                    String quantityI = "quantity"+i;
                    int quantity = Integer.parseInt(request.getParameter(quantityI));
                    Cupcake cupcake = new Cupcake(top, bot, quantity);
                    arrayList.add(cupcake);
                }
                String userName = (String) request.getSession().getAttribute("username");
                User userOn = um.getUser(userName);
                OrderMapper om = new OrderMapper();
                boolean money = om.checkMoney(arrayList, userOn);
                if(money){
                    om.createOrder(arrayList, userOn);
                }
                
                
                break;
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void startShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            TopBottomMapper tbm = new TopBottomMapper();
            List<Bot> listBot = tbm.getBot();
            List<Top> listTop = tbm.getTop();
            request.getSession().setAttribute("listBot", listBot);
            request.getSession().setAttribute("listTop", listTop);
            ArrayList<Bot> list = (ArrayList<Bot>) request.getSession().getAttribute("listBot");
            list.get(0).getPrice();

            request.getRequestDispatcher("shop.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
