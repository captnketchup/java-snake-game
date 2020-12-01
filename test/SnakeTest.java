import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SnakeTest {

    @Test
    public void checkBorderCollisions() {
        Snake testSnake = new Snake();
        for(int i = 0; i < 40; ++i){        //map is 32x32 blocks
            testSnake.move();
        }
        assertTrue(testSnake.checkCollisions());        //ought to be true because snake hit border
    }

    @Test
    public void checkSelfCollision() {
        Snake testSnake = new Snake();
        for (int i = testSnake.bodyParts; i > 0; i--) {
            if ((testSnake.x[0] == testSnake.x[i] && testSnake.y[0] == testSnake.y[i])) {
                assertTrue(testSnake.checkCollisions());
            }
        }
    }
}