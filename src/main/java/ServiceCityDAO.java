import javax.persistence.EntityManager;
import javax.persistence.PersistenceUtil;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class ServiceCityDAO implements CityDAO {
    Scanner scanner = new Scanner(System.in);

    @Override
    public List<City> getAllCity() {
        List<City> cities;
        EntityManager entityManager = Config.getEm();
        entityManager.getTransaction().begin();
        TypedQuery<City> query = entityManager.createQuery("SELECT s FROM City s", City.class);
        cities = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        cities.forEach(System.out::println);
        return cities;
    }

    @Override
    public City getCityByID(int id) {
        EntityManager manager = Config.getEm();
        manager.getTransaction().begin();
        City city = manager.find(City.class, id);
        manager.getTransaction().commit();
        manager.close();
        return city;
    }

    @Override
    public void createCity(City city) {
        EntityManager manager = Config.getEm();
        manager.getTransaction().begin();
        manager.persist(city);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void updateCity(City city) {
        System.out.println("Введите новое название города:");
        String name = scanner.nextLine();
        city.setCityName(name);

        EntityManager manager = Config.getEm();
        manager.getTransaction().begin();
        manager.merge(city);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void deleteCity(City city) {
        EntityManager manager = Config.getEm();
        manager.getTransaction().begin();
        City city1 = manager.find(City.class, city.getCityId());
        manager.remove(city1);
        manager.getTransaction().commit();
        manager.close();
    }
}