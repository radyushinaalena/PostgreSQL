import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceEmployeeDAO implements EmployeeDAO {

    private final String user = "postgres";
    private final String password = "admin";
    private final String url = "jdbc:postgresql://localhost:5434/skypro";

    @Override
    public List<Employee> createEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию");
        String lastName = scanner.nextLine();
        System.out.println("Введите пол");
        String gender = scanner.nextLine();
        System.out.println("Введите возраст");
        String age = scanner.nextLine();
        System.out.println("Введите id города");
        String cityId = scanner.nextLine();
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO employee(first_name, last_name, gender, age,city_id) VALUES ('" + firstName + "','" + lastName + "','" + gender + "','" + age + "','" + cityId + "')")) {
            System.out.println("Сотрудник создан");
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getEmployeeById(int id) {
        List<Employee> employees = new ArrayList<>();

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("select * from employee where id=" + id +" order by id")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idEmployee = resultSet.getInt("id");
                String firstNameEmployee = resultSet.getString("first_name");
                String lastNameEmployee = resultSet.getString("last_name");
                String genderEmployee = resultSet.getString("gender");
                int ageEmployee = resultSet.getInt("age");
                int cityIdEmployee = resultSet.getInt("city_id");

                employees.add(new Employee(idEmployee, firstNameEmployee, lastNameEmployee, genderEmployee, ageEmployee, cityIdEmployee));

            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }

        return employees;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("select * from employee order by id")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idEmployee = resultSet.getInt("id");
                String firstNameEmployee = resultSet.getString("first_name");
                String lastNameEmployee = resultSet.getString("last_name");
                String genderEmployee = resultSet.getString("gender");
                int ageEmployee = resultSet.getInt("age");
                int cityIdEmployee = resultSet.getInt("city_id");

                employees.add(new Employee(idEmployee, firstNameEmployee, lastNameEmployee, genderEmployee, ageEmployee, cityIdEmployee));

            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }

        return employees;
    }

    @Override
    public void updateEmployee(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию");
        String lastName = scanner.nextLine();
        System.out.println("Введите пол");
        String gender = scanner.nextLine();
        System.out.println("Введите возраст");
        String age = scanner.nextLine();
        System.out.println("Введите id города");
        String cityId = scanner.nextLine();

        try (final Connection connection = DriverManager.getConnection(url, user, password);

             PreparedStatement statement =
                     connection.prepareStatement("UPDATE employee SET first_name='" + firstName + "',last_name='" + lastName + "',gender='" + gender + "',age='" + age + "',city_id='" + cityId + "' where id =" + id)) {
            System.out.println("Сотрудник изменен");
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("DELETE FROM employee WHERE id=" + id)) {
            System.out.println("Сотрудник удален");
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }
}
