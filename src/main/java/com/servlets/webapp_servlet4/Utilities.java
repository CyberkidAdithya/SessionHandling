package com.servlets.webapp_servlet4;

import java.sql.*;

public class Utilities {

    // JDBC details
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "tswnciJ-";

    public static ResultSet rs;
    public static PreparedStatement stmt;
    public static Connection CONNECTION = null;

    //	boolean status = preServlet();

    public static Connection createConnection() throws SQLException, ClassNotFoundException { // Main()
        System.out.println("createConnection called");
        Class.forName("org.postgresql.Driver");
        CONNECTION = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        return CONNECTION;
    }

    public static boolean validateOldUser(String currentUname, String currentPwd) {
        try {
            CONNECTION = createConnection();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String userQuery = "SELECT * FROM UserAccount " +
                "WHERE username = ? AND password = ?;";     //crypt(?, password)
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

    public static boolean validateNewUser(String currentUname) {
        try {
            CONNECTION = createConnection();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String userQuery = "SELECT * FROM UserAccount WHERE username = ?";     //crypt(?, password)
        try {
            stmt = CONNECTION.prepareStatement(userQuery);
            stmt.setString(1, currentUname);
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

    public static void createAccount(String currentUname, String currentPwd) {
        try {
            stmt = CONNECTION.prepareStatement("INSERT INTO UserAccount VALUES (DEFAULT, ?, ?);");
            stmt.setString(1, currentUname);
            stmt.setString(2, currentPwd);
            int rowsUpdated = stmt.executeUpdate();
            System.out.println(rowsUpdated + " ROWS AFFECTED");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fetchRecords() {
        try {
            String query = "select * from userAccount" +
                    " where OrderID in" +
                    " (select top 2 userID from userAccount" +
                    " order by userID desc);";

            stmt = CONNECTION.prepareStatement("INSERT INTO UserAccount VALUES (DEFAULT, ?, ?);");
            rs = stmt.executeQuery();
//            System.out.println(rowsUpdated + " ROWS AFFECTED");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
