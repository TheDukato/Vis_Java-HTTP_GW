package com.example.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_API {
    public static List<Measurement> getDataFromDB (int idLocation,String date) {
        Connection conn = getRemoteConnection();
        //Measurement measur =
        List<Measurement> returnned = new ArrayList<>();
        try {

            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery("Select * from historian where timeOfProbe > " + date + " AND ID_Location = " + idLocation + " LIMIT 1000");
            while (result.next()) {
                returnned.add(new Measurement(
                        result.getString(5),
                        result.getString(3),
                        result.getString(4),
                        Integer.parseInt(result.getString(2))));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnned;
    }
    public static Measurement getLastDataFromDB (int idLocation) {
        Connection conn = getRemoteConnection();
        Measurement returnned = new Measurement();
        try {
            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery("Select * from historian where ID_Location = " + idLocation + " ORDER BY timeOfProbe desc LIMIT 1");
            result.next();
            return new Measurement(
                        result.getString(5),
                        result.getString(3),
                        result.getString(4),
                        Integer.parseInt(result.getString(2)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnned;
    }
    private static Connection getRemoteConnection() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");

            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbName = "ACQ";
            String userName = "admin";
            String password = "adminadmin";
            String hostname = "database-2.cxx3vliix7rd.us-east-1.rds.amazonaws.com";
            String port = "3306";
            String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
            //logger.trace("Getting remote connection with connection string from environment variables.");
            System.out.println("Getting remote connection with connection string from environment variables.");
            Connection con = DriverManager.getConnection(jdbcUrl);
            System.out.println("Remote connection successful.");
            //logger.info();
            return con;
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.toString());
            //logger.warn(e.toString());
        }
        catch (SQLException e) {
            System.out.println(e.toString());
            //logger.warn(e.toString());
        }

        return null;
    }
}
