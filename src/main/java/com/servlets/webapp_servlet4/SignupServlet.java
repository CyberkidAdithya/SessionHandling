/*

flag1 - checks if given username already exists

web.xml - deployment descriptor

 */

package com.servlets.webapp_servlet4;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignupServlet", value = "/SignupServlet")
public class SignupServlet extends HttpServlet {

    @Override   // void service(), void doGet(),...
    public void doGet(HttpServletRequest req, HttpServletResponse res) {

        String username = req.getParameter("uname");
        System.out.println("DEBUG: " + username);
        String password = req.getParameter("pwd");
//        System.out.println("DEBUG: " + password);

        boolean flag1 = Utilities.validateNewUser(username);
//        System.out.println("Inside doPost");

        PrintWriter out;
        try {
            out = res.getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        out.println("<html><body>");
        if (flag1) {
            out.println("<h1>" + "Username already exists." + "</h1>");
        } else {
            boolean makeNewAccount = false;     // true - makes new account
            if (makeNewAccount) {
                Utilities.createAccount(username, password);
            }
            out.println("<h1>" + "New User account created." + "</h1>");
        }
        out.println("</body></html>");
    }

}
