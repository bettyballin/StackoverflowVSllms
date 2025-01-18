import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BeforeSuite {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface AfterClass {
    boolean alwaysRun() default false;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {}

public class CalcTest {
    @BeforeSuite
    public void setUp() { /* setup code here */ }

    @AfterClass(alwaysRun = true)
    public void teardown() {  /* cleanup/teardown code goes here */}

    @Test
    public void testAddition(){ /* testing integration */}

    public static void main(String[] args) {
    }
}