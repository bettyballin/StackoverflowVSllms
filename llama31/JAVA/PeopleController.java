import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@RestController
@RequestMapping("/api/people")
public class PeopleController {

  @Autowired
  private PeopleService peopleService;

  @GetMapping
  public ResponseEntity<String> getPeople() {
    List<Person> people = peopleService.getPeople();
    String xmlResponse = peopleService.convertToXml(people);
    return ResponseEntity.ok(xmlResponse);
  }

  public static void main(String[] args) {
  }
}

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@Service
public class PeopleService {

  @Autowired
  private PersonRepository personRepository;

  public List<Person> getPeople() {
    return personRepository.findAll();
  }

  public String convertToXml(List<Person> people) {
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
      Marshaller marshaller = jaxbContext.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

      StringBuilder sb = new StringBuilder();
      for (Person person : people) {
        marshaller.marshal(person, sb);
      }

      return sb.toString();
    } catch (JAXBException e) {
      // Handle the exception
      return "";
    }
  }
}

// Added Person and PersonRepository classes for completeness
class Person {}

interface PersonRepository {
  List<Person> findAll();
}