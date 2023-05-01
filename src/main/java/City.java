import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer city_Id;
    @Column(name = "city_name")
    private String cityName;

    @OneToMany(mappedBy = "city_Id", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Employee> employees;

    public City(String cityName) {
        this.cityName = cityName;
    }

    public City() {
    }

    public int getCityId() {
        return city_Id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCityId(int cityId) {
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
