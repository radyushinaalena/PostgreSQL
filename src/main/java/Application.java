import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

        EmployeeDAO employeeDAO = new ServiceEmployeeDAO();

        employeeDAO.createEmployee();

        List<Employee> employeeList = employeeDAO.getAllEmployees();

        for (Employee employee : employeeList) {
            // Создаем соединение с базой данных внутри try-with-resources,
            // чтобы автоматически закрыть его после использования
            System.out.print(" Id: " + employee.getId());
            System.out.print(" Имя: " + employee.getFirstName());
            System.out.print(" Фамилия: " + employee.getLastName());
            System.out.print(" Пол: " + employee.getGender());
            System.out.print(" Возраст: " + employee.getAge());
            System.out.print(" Id города: " + employee.getCityId());
            System.out.println();
        }
        employeeDAO.deleteEmployee(13);

        List<Employee> employeeList2 = employeeDAO.getEmployeeById(4);
        for (Employee employee : employeeList2) {
            // Создаем соединение с базой данных внутри try-with-resources,
            // чтобы автоматически закрыть его после использования
            System.out.print(" Id: " + employee.getId());
            System.out.print(" Имя: " + employee.getFirstName());
            System.out.print(" Фамилия: " + employee.getLastName());
            System.out.print(" Пол: " + employee.getGender());
            System.out.print(" Возраст: " + employee.getAge());
            System.out.print(" Id города: " + employee.getCityId());
            System.out.println();
        }
        employeeDAO.updateEmployee(9);

        List<Employee> employeeList3 = employeeDAO.getAllEmployees();

        for (Employee employee : employeeList3) {
            // Создаем соединение с базой данных внутри try-with-resources,
            // чтобы автоматически закрыть его после использования
            System.out.print(" Id: " + employee.getId());
            System.out.print(" Имя: " + employee.getFirstName());
            System.out.print(" Фамилия: " + employee.getLastName());
            System.out.print(" Пол: " + employee.getGender());
            System.out.print(" Возраст: " + employee.getAge());
            System.out.print(" Id города: " + employee.getCityId());
            System.out.println();
        }
    }
}