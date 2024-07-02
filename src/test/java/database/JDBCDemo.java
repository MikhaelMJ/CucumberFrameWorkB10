package database;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        // создать урл = jdbc:mysql://Hostname to my database:port
        String dbURL = "jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName = "syntax_hrm";
        String password = "syntaxhrm123";

        Connection conn;
        Statement statement;
        ResultSet resultSet;

        try {
            //создаем соединение с базой данных
            conn=DriverManager.getConnection(dbURL, userName, password);
            System.out.println(" connection ");

            //создаем объект соединения
            statement=conn.createStatement();

            //отправляем запрос в бд
            resultSet=statement.executeQuery("select * from persons");

            while (resultSet.next()) {
                String fname = resultSet.getString("FirstName") + " " + resultSet.getString("LastName");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
