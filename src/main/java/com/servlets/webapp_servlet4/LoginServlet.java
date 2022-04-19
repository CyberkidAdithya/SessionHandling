/*

flag2 - checks if given username & password already exists

web.xml - deployment descriptor

 */

package com.servlets.webapp_servlet4;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override   // void service(), void doGet(),...
    public void doPost(HttpServletRequest req, HttpServletResponse res) {

        String username = req.getParameter("uname");
        String password = req.getParameter("pwd");

        boolean flag2 = Utilities.validateOldUser(username, password);

        PrintWriter out;
        try {
            out = res.getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        out.println("<html><body>");
        if (flag2) {
            out.println("<h1>" + "Login successful!" + "</h1>");
        } else {
            out.println("<h1>" + "Login failed!" + "</h1>");
        }
        out.println("</body></html>");
    }

}
