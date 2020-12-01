import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreListTest {
    Player testPlayer;
    ScoreList testList;

    @Before
    public void make(){
        testPlayer = new Player("Tesztelo Tamas", 10);
        testList = new ScoreList();
    }

    @Test
    public void isScoreListGenerated() {
        Assert.assertNotNull(testList);
    }

    @Test
    public void add() {
        testList.add(testPlayer);
        Assert.assertTrue(testList.data.contains(testPlayer));
    }

    @Test
    public void listLength() {
        int listLength = testList.data.size();
        testList.add(new Player("Kettes Kalman", 30));
        Assert.assertEquals(listLength+1, testList.data.size());
    }
}