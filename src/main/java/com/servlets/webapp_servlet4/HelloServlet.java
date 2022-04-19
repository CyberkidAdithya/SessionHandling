package com.servlets.webapp_servlet4;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", value = "/HelloServlet")
public class HelloServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) {

        String username = req.getParameter("uname");
        System.out.println("DEBUG: " + username);
        String password = req.getParameter("pwd");
        System.out.println("DEBUG: " + password);
//
        // Condition
//		boolean flag = username.equals("cyberkid") && password.equals("ckid1234");
        boolean flag = Utilities.validateOldUser(username, password);
        System.out.println("Inside doPost");

        PrintWriter out;
        try {
            out = res.getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        out.println("Login is " + (flag ? "successful" : "unsuccessful") + "!");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        String message = "Welcome ";
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }
}
