package lessonCore7.project;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class DataBaseRepository {
    // путь к бд
    private static final String DB_PATH = "jdbc:sqlite:lihs.db";
    // строка с SQL-запросом на создание таблицы weather
    private String createTableQuery = "CREATE TABLE IF NOT EXISTS weather (\n" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "city TEXT NOT NULL,\n" +
            "date_time TEXT NOT NULL,\n" +
            "weather_text TEXT,\n" +
            "temperature REAL NOT NULL\n" +
            ");";
    //срока с SQL-запросом на  добавление данных в таблицу weather
    private String insertWeatherQuery = "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES (?,?,?,?)";
    private static final  String SELECT_ALL_DATA = "SELECT * FROM weather;";


    // Подключения драйвера субд sqlite
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //подключение к бд, если файла нет, он создастся
    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_PATH);
        return connection;
    }
    // Создание в бд таблицы weather, если ее еще нет
    private void createTableIfNotExists() {
        try (Connection connection = getConnection()) {
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // метод сохранения погоды в бд
    public boolean saveWeatherToDataBase(String city, String date, String text, Double temp)  {
        createTableIfNotExists();
        try (Connection connection = getConnection();
             PreparedStatement saveWeather = connection.prepareStatement(insertWeatherQuery)) {
            saveWeather.setString(1, city);
            saveWeather.setString(2, date);
            saveWeather.setString(3, text);
            saveWeather.setDouble(4, temp);
            return saveWeather.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void getAllSavedData () {
        try (Connection connection = getConnection()) {
           ResultSet resultSet = connection.createStatement().executeQuery(SELECT_ALL_DATA);
            while (resultSet.next()) {
                System.out.print(resultSet.getString("city"));
                System.out.print(" ");
                System.out.print(resultSet.getString("date_time"));
                System.out.print(" ");
                System.out.print(resultSet.getString("weather_text"));
                System.out.print(" ");
                System.out.print(resultSet.getDouble("temperature"));
                System.out.println(" ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}




