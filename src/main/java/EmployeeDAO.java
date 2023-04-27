import java.util.List;

public interface EmployeeDAO {
    List<Employee> createEmployee();
    List<Employee> getEmployeeById(int id);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee id);
    void deleteEmployee(Employee id);
}
