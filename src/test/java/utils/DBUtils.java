package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {
    static Connection connection;
    static ResultSet resultSet;

    //метод создания соединения с базой данных, вернуть конекшн
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(ConfigReader.getPropertyValue("dbUrl"),
                    ConfigReader.getPropertyValue("dbUserName"),
                    ConfigReader.getPropertyValue("dbPassword"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }

    //метод возвращает результат запроса из бд
    public static ResultSet getResultSet(String sqlQuery) throws SQLException {

        resultSet = getConnection().createStatement().executeQuery(sqlQuery);
        return resultSet;
    }

    //метод возвращает объект результата в виде списка карт
    public static List<Map<String, String>> mapList(String sqlQuery) throws SQLException {
        List<Map<String, String>> listOfRowMaps;
        Map<String, String> rowMap;
        listOfRowMaps = new ArrayList<>();

        resultSet = getResultSet(sqlQuery);
        ResultSetMetaData metaData = resultSet.getMetaData();

        while (resultSet.next()) {
            rowMap = new LinkedHashMap<>();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                rowMap.put(metaData.getColumnName(i), resultSet.getString(i));
            }
            listOfRowMaps.add(rowMap);
        }
        return listOfRowMaps;

    }

    //метод возвращает данные из объекта набора результата в виде карты
    public static Map<String, String> mapFromBD(String sqlQuery) {
        Map<String, String> rowMap = new LinkedHashMap<>();
        try {
            resultSet = getResultSet(sqlQuery);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            resultSet.next();
            for (int i = 1; i < resultSetMetaData.getColumnCount(); i++) {
                rowMap.put(resultSetMetaData.getColumnName(i), resultSet.getString(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowMap;
    }
}
