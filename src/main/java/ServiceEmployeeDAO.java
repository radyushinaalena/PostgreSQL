import javax.persistence.*;
import java.util.List;
import java.util.Scanner;


public class ServiceEmployeeDAO implements EmployeeDAO {

    @Override
    public void createEmployee(Employee employee) {
        EntityManager entityManager = Config.getEm();
        entityManager.getTransaction().begin();
        City city = entityManager.find(City.class, employee.getCityId().getCityId());
        employee.setCityId(city);
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Employee getEmployeeById(int id) {


        EntityManager entityManager = Config.getEm();
        entityManager.getTransaction().begin();

        String jpqlQuery = "select e from Employee e where e.id= :id order by e.id";

        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);

        // Устанавливаем значение параметра minAge в запросе
        query.setParameter("id", id);

        // Выполняем запрос и получаем результат в виде списка студентов
        Employee employee = query.getSingleResult();

        // Завершаем транзакцию
        entityManager.getTransaction().commit();
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {

        EntityManager entityManager = Config.getEm();
        entityManager.getTransaction().begin();

        String jpqlQuery = "select e from Employee e order by e.id";
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
        int cityId = scanner.nextInt();
        CityDAO cityDAO = new ServiceCityDAO();
        id.setFirstName(firstName);
        id.setLastName(lastName);
        id.setGender(gender);
        id.setAge(Integer.parseInt(age));
        id.setCityId(cityDAO.getCityByID(cityId));

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
