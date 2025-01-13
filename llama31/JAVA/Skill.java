import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// Entity class
@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// DAO class
@Repository
public class SkillDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Skill> getAllSkills() {
        Session session = sessionFactory.getCurrentSession();
        Query<Skill> query = session.createQuery("FROM Skill", Skill.class);
        return query.getResultList();
    }

    public static void main(String[] args) {
        // Create a new SkillDao object
        SkillDao skillDao = new SkillDao();

        // Create a new SessionFactory object (Note: You need to configure Hibernate properly)
        // SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Set the SessionFactory object to the SkillDao object (Note: This is usually done by Spring)
        // skillDao.setSessionFactory(sessionFactory);

        // Get all skills
        // List<Skill> skills = skillDao.getAllSkills();

        // Print the skills
        // for (Skill skill : skills) {
        //     System.out.println(skill.getName());
        // }
    }
}