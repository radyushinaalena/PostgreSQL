import java.util.List;

public interface EmployeeDAO {
    void createEmployee();
    List<Employee> getEmployeeById(int id);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee id);
    void deleteEmployee(Employee id);
}
