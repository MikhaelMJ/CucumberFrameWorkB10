package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Recap {
    public static void main(String[] args) {
        String dbUserName = "syntax_hrm";
        String dbPassword = "syntaxhrm123";
        String dbURL = "jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        try {
            Connection connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from ohrm_skill");

            ResultSetMetaData metaData = resultSet.getMetaData();

            List<Map<String, String>> mapListFromDB = new ArrayList<>();

            Map<String, String> rowMap;

            while (resultSet.next()) {
                // создается карта для каждой строки
                rowMap = new LinkedHashMap<>();

                // проходим по стобцам
                for (int i = 1; i<= metaData.getColumnCount(); i++) {
                    rowMap.put(metaData.getColumnName(i), resultSet.getString(i));
                }
                System.out.println(rowMap);
                mapListFromDB.add(rowMap);
            }
            System.out.println(mapListFromDB);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
