package com.example.chutunglamnsc.servlet;

import com.example.chutunglamnsc.dao.UserDao;
import com.example.chutunglamnsc.model.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = dao.getUser(username, password); // '' or 1=1--
        if (user != null) {
            response.sendRedirect("index.jsp");
        }else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
