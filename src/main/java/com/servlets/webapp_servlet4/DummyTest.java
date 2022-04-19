package com.servlets.webapp_servlet4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "Diko", value = "/Diko")
public class DummyTest extends HttpServlet {
    private String message;

    // JDBC details
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "tswnciJ-";

    public static ResultSet rs;
    public static PreparedStatement stmt;
    public static Connection CONNECTION=null;

//	boolean status = preServlet();

    public static Connection createConnection() throws ClassNotFoundException, SQLException { // Main()
        System.out.println("createConnection called");
        Class.forName("org.postgresql.Driver");
        CONNECTION = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        return CONNECTION;
    }

    public boolean validateUser(String currentUname, String currentPwd) {
        String userQuery = "SELECT * FROM UserAccount WHERE username = ? AND password = crypt(?, password);";
        try {
            stmt = CONNECTION.prepareStatement(userQuery);
            stmt.setString(1, currentUname);
            stmt.setString(2, currentPwd);
//			stmt.executeUpdate();
            rs = stmt.executeQuery();
            if (!rs.next()) {
                System.out.println("User not found");
                return false;
            }
//			userID = rs.getInt(1);	// get current user's ID
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Welcome back, " + currentUname);
        return true;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection=DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println(connection);
        } catch (Exception e)  {
            e.printStackTrace();
        }

    }
}
