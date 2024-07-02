package database;

import java.sql.DriverManager;
import java.sql.*;

public class JDBCDemo2 {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName = "syntax_hrm";
        String password = "syntaxhrm123";

        try {
            //создаем соединение с базой данных
            Connection conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println(" connection ");

            //создаем объект соединения
            Statement statement = conn.createStatement();

            String sqlQuery = "select * from persons";

            //отправляем запрос в бд
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            //получить данные о данных
            ResultSetMetaData resultSetMetadata = resultSet.getMetaData();
            //получить количество столбцов
            int cols = resultSetMetadata.getColumnCount();

            //получить название столбца
            String col1Name = resultSetMetadata.getColumnName(1);

            for (int i = 1; i <= cols; i++) {

                col1Name = resultSetMetadata.getColumnName(i);

            }
            System.out.println("_______________________________________________________________");

            while (resultSet.next()) {
                for (int i = 1; i <= resultSetMetadata.getColumnCount(); i++) {
                    col1Name = resultSetMetadata.getColumnName(i);
                    String data = resultSet.getString(col1Name).toString();
                    System.out.print(data+"      ");
                }
                System.out.println();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
