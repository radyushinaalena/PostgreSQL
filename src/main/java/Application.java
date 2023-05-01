import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException, Exception {
        CityDAO cityDAO = new ServiceCityDAO();

        City city3 = new City("Питер");

        Employee employee = new Employee("Гена", "Генадик", "Муж", 43, city3);
        Employee employee2 = new Employee("Алексей", "Алекс", "Муж", 24, city3);
        List list = new ArrayList<>();
        list.add(employee2);
        list.add(employee);
        city3.setEmployees(list);
        cityDAO.createCity(city3);

        EmployeeDAO employeeDAO = new ServiceEmployeeDAO();
        employeeDAO.updateEmployee(employeeDAO.getEmployeeById(46));
        CityDAO cityDAO2 = new ServiceCityDAO();
        System.out.println(cityDAO2.getCityByID(21).getEmployees());

        cityDAO.deleteCity(cityDAO.getCityByID(12));
    }
}