import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Test_6_6 {
    @Id
    private int id; // Every entity must have an ID

    @OneToMany(mappedBy = "test")
    private TestExtension testExtension;

    // Constructor, getters, and setters
    public Test_6() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TestExtension getTestExtension() {
        return testExtension;
    }

    public void setTestExtension(TestExtension testExtension) {
        this.testExtension = testExtension;
    }

    public static void main(String[] args) {
        // Example usage
        Test_6 test = new Test_6();
        test.setId(1);
        TestExtension extension = new TestExtension();
        extension.setTest(test);
        test.setTestExtension(extension);
    }
}

// Minimal definition for TestExtension
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
class TestExtension {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name="test_id")
    private Test_6 test;

    public TestExtension() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Test_6 getTest() {
        return test;
    }

    public void setTest(Test_6 test) {
        this.test = test;
    }
}