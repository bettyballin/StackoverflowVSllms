import java.util.List;
import javax.sql.DataSource;

// Assuming a basic JDBC setup
public class StateCountryManager {
  private DataSource dataSource;

  public List<Country> getCountries() {
    // Query countries table and return a list of Country objects
    return null; // Add your implementation here
  }

  public List<State> getStates(Country country) {
    // Query states table using the country ID and return a list of State objects
    return null; // Add your implementation here
  }
}

class Country {
  private int id;
  private String name;
  private String code;

  // Getters and setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}

class State {
  private int id;
  private Country country;
  private String name;
  private String code;

  // Getters and setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public static void main(String[] args) {
  }
}