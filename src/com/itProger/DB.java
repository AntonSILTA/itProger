package com.itProger;

import java.sql.*;

public class DB {

    private final String HOST = "localhost";
    private final String PORT = "3307";
    private final String DB_NAME = "java_db";
    private final String LOGIN = "root";
    private final String PASS = "root";

    private Connection dbConn = null;

    private Connection getDbConnection () throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName ("com.mysql.cj.jdbc.Driver");

        dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);
        return dbConn;
    }

    public void createTable (String tableName) throws ClassNotFoundException, SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS" + tableName +
                " (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR (50), password VARCHAR (100) )"
                + "ENGINE=MYISAM;";

        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(sql);
    }

    public void incertArticle (String title, String text, String date, String avtor) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO `articles` (title, text, date, avtor) VALUES (?, ?, ?, ?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, title);
        prSt.setString(2, text);
        prSt.setString(3, date);
        prSt.setString(4, avtor);

        prSt.executeUpdate();

    }
    public void getArticles (String table) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM" + table;

        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);
        while(res.next()) {
            System.out.println(res.getString("id"));
        }
    }
    public void updateArticles () throws ClassNotFoundException, SQLException {
        String sql = "UPDATE `articles` SET `title` = ? WHERE `id` = 2";

        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, "Renewed article");


        prSt.executeUpdate();

    }

    public void deleteSomething () throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM `articles` WHERE `id` = 4";
        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(sql);
    }


}
