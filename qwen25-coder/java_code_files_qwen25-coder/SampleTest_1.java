import org.testng.annotations.Test;
import org.testng.Assert;

public class SampleTest_1 {

    @Test(groups = "functional")
    public void testAddition() {
        Assert.assertEquals(2, 1 + 1);
    }

    @Test(groups = "regression")
    public void testSubtraction() {
        Assert.assertEquals(1, 3 - 2);
    }

    public static void main(String[] args) {
    }
}