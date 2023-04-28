import javax.persistence.*;
import java.util.List;
import java.util.Scanner;


public class ServiceEmployeeDAO implements EmployeeDAO {

    @Override
    public Employee createEmployee() {
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

        Employee employee = new Employee();
        employee.setId(null);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setGender(gender);
        employee.setAge(Integer.parseInt(age));
        employee.setCityId(Integer.parseInt(cityId));

        EntityManager entityManager = Config.getEm();

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();

        return null;
    }

    @Override
    public List<Employee> getEmployeeById(int id) {


        EntityManager entityManager = Config.getEm();
        entityManager.getTransaction().begin();

        String jpqlQuery = "select e from Employee e where e.id= :id order by e.id";

        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);

        // Устанавливаем значение параметра minAge в запросе
        query.setParameter("id", id);

        // Выполняем запрос и получаем результат в виде списка студентов
        List<Employee> employeeList = query.getResultList();

        // Завершаем транзакцию
        entityManager.getTransaction().commit();
        return employeeList;
    }

    @Override
    public List<Employee> getAllEmployees() {

        EntityManager entityManager = Config.getEm();
        entityManager.getTransaction().begin();

        String jpqlQuery ="select e from Employee e order by e.id";
        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);

        List<Employee> employeeList = query.getResultList();

        entityManager.getTransaction().commit();
        return employeeList;
    }

    @Override
    public void updateEmployee(Employee id) {
        EntityManager entityManager = Config.getEm();
        entityManager.getTransaction().begin();

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

        id.setFirstName(firstName);
        id.setLastName(lastName);
        id.setGender(gender);
        id.setAge(Integer.parseInt(age));
        id.setCityId(Integer.parseInt(cityId));

        entityManager.merge(id);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void deleteEmployee(Employee id) {
        EntityManager entityManager = Config.getEm();
        entityManager.getTransaction().begin();

        String jpqlQuery = "select e from Employee e where e.id= :id";

        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);

        query.setParameter("id", id.getId());

        List<Employee> employeeList = query.getResultList();

        entityManager.remove(employeeList.get(0));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
