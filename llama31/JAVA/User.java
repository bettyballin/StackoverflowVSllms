import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;

@Entity(name = "USER")
public class User {
  @Id
  private int id;

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "LAST_NAME")
  private String lastName;

  private Date dateOfBirth;

  private String email;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Address> addresses;

  @ManyToOne
  private Department department;

  @ManyToMany(cascade = CascadeType.ALL)
  private List<Role> roles;

  public static void main(String[] args) {
  }
}