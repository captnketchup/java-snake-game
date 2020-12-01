import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppleTest {
    Apple testApple;

    @Before
    public void make() {
        testApple = new Apple();
    }

    @Test
    public void isAppleGenerated() {
        Assert.assertNotNull(testApple);
    }

    @Test
    public void getX() {
        Assert.assertEquals(testApple.x, testApple.getX());
    }

    @Test
    public void getY() {
        Assert.assertEquals(testApple.y, testApple.getY());
    }

    @Test
    public void isFastTest() {
        if (testApple.n == 0) {
            Assert.assertEquals(testApple.isFast, true);
        }
    }

    @Test
    public void isSlowTest() {
        if (testApple.n == 1) {
            Assert.assertEquals(testApple.isSlow, true);
        }
    }

}