import java.util.List;

public class PersonService {
    private final PersonDAO personDAO;

    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public Person getPersonWithAddresses(int id) {
        Person person = personDAO.getPersonById(id);
        if (person != null) {
            List<Address> addresses = personDAO.loadAddressesForPerson(person);
            person.setAddresses(addresses);
        }
        return person;
    }

    // Other methods... 

    public static void main(String[] args) {
    }
}

class PersonDAO {
    public Person getPersonById(int id) {
        return new Person();
    }

    public List<Address> loadAddressesForPerson(Person person) {
        return null;
    }
}

class Person {
    public void setAddresses(List<Address> addresses) {
    }
}

class Address {
}