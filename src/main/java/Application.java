import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {

// Создаем переменные с данными для подключения к базе
        final String user = "postgres";
        final String password = "4717";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

// Создаем соединение с базой с помощью Connection
// Формируем запрос к базе с помощью PreparedStatement
        try (final Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {

// Подставляем значение вместо wildcard
            statement.setInt(1, 5);

// Делаем запрос к базе и результат кладем в ResultSet
            final ResultSet resultSet = statement.executeQuery();

// Методом next проверяем есть ли следующий элемент в resultSet
// и одновременно переходим к нему, если таковой есть
            while (resultSet.next()) {

// C помощью методов getInt и getString получаем данные о работнике из resultSet
                String employeeName = "Имя сотрудника: " + resultSet.getString("first_name");
                String employeeLastName = "Фамилия сотрудника: " + resultSet.getString("last_name");
                String gender = "Пол сотрудника: " + resultSet.getString("gender");
                String age = "Возраст: " + resultSet.getString("age");
                String city = "Город: " + resultSet.getString("city_id");

                // Выводим данные в консоль
                System.out.println(employeeName + "\n" +
                        employeeLastName  + "\n" +
                        gender + "\n" +
                        age + "\n" +
                        city);

            }
        }
    }
}
