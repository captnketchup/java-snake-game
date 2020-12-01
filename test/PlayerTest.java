import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testToString() {
        Player testPlayer = new Player("Teszt Tamas", 0);
        Assert.assertEquals("Teszt Tamas 0", testPlayer.toString());
    }
}