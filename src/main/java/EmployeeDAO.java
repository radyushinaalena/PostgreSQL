import java.util.List;

public interface EmployeeDAO {
    List<Employee> createEmployee();
    List<Employee> getEmployeeById(int id);
    List<Employee> getAllEmployees();
    void updateEmployee(int id);
    void deleteEmployee(int id);
}
