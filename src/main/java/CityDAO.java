import java.util.List;

public interface CityDAO {
    List<City> getAllCity();

    City getCityByID(int id);

    void createCity(City city);

    void updateCity(City city);

    void deleteCity(City city);
}