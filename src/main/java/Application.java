import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO = new ServiceEmployeeDAO();

        employeeDAO.createEmployee();

        employeeDAO.deleteEmployee(employeeDAO.getEmployeeById(32).get(0));

        employeeDAO.updateEmployee(employeeDAO.getEmployeeById(18).get(0));

        List<Employee> employeeList = employeeDAO.getAllEmployees();
        for (Employee employee : employeeList) {

            System.out.print(" Id: " + employee.getId());
            System.out.print(" Имя: " + employee.getFirstName());
            System.out.print(" Фамилия: " + employee.getLastName());
            System.out.print(" Пол: " + employee.getGender());
            System.out.print(" Возраст: " + employee.getAge());
            System.out.print(" Id города: " + employee.getCityId());
            System.out.println();
        }

        List<Employee> employeeList2 = employeeDAO.getEmployeeById(18);
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
    }
}