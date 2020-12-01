import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class SnakeTest {
    Snake testSnake;
    @Before
    public void make(){
        testSnake = new Snake();
    }

    @Test
    public void isSnakeGenerated() {
        Assert.assertNotNull(testSnake);
    }

    @Test
    public void checkBorderCollisions() {
        for(int i = 0; i < 40; ++i){        //map is 32x32 blocks
            testSnake.move();
        }
        assertTrue(testSnake.checkCollisions());        //ought to be true because snake hit border
    }

    @Test
    public void checkSelfCollision() {
        for (int i = testSnake.bodyParts; i > 0; i--) {
            if ((testSnake.x[0] == testSnake.x[i] && testSnake.y[0] == testSnake.y[i])) {
                assertTrue(testSnake.checkCollisions());
            }
        }
    }

    @Test
    public void snakeConstructorTest() {
        Assert.assertEquals(2, testSnake.bodyParts);
        Assert.assertEquals(new Color(69, 255, 69), testSnake.c);
        Assert.assertEquals(testSnake.direction, Direction.DOWN);
    }


}