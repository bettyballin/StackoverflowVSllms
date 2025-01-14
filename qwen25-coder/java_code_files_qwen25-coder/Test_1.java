import javax.persistence.*;

@Entity
@Table(name = "test")
public class Test_1 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_id_seq")
    @SequenceGenerator(name = "test_id_seq", sequenceName = "test_id_seq")
    private Long testId;

    private String name;

    @OneToOne(mappedBy = "test", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Test_1Extension testExtension;

    // getters and setters
    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Test_1Extension getTestExtension() {
		return testExtension;
	}

	public void setTestExtension(Test_1Extension testExtension) {
		this.testExtension = testExtension;
	}
}

@Entity
@Table(name = "testExtension")
public class Test_1Extension {

    @Id
    @Column(name = "test_id")
    private Long testId;

    private String summary;
    private String homepage;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "test_id")
    private Test_1 test;

    // getters and setters
    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Test_1 getTest() {
        return test;
    }

    public void setTest(Test_1 test) {
        this.test = test;
    }

    public static void main(String[] args) {
    }
}