import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    Player testPlayer;

    @Before
    public void make() {
        testPlayer = new Player("Teszt Tamas", 0);
    }

    @Test
    public void isPlayerGenerated() {
        Assert.assertNotNull(testPlayer);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("Teszt Tamas 0", testPlayer.toString());
    }
}