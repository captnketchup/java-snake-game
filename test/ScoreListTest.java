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
        testList.add(new Player("Uhlrik Ubul", 70));
        testList.add(new Player("Ujjatek Odon", 50));
    }

    @Test
    public void isScoreListGenerated() {
        Assert.assertNotNull(testList);
    }

    @Test
    public void add() {
        testList.add(testPlayer);
        Assert.assertTrue(testList.contains(testPlayer));
    }

    @Test
    public void listLength() {
        int listLength = testList.size();
        testList.add(new Player("Kettes Kalman", 30));
        Assert.assertEquals(listLength+1, testList.size());
    }

    @Test
    public void listSorted() {
        ScoreList sortedList = new ScoreList();
        Player testPlayer1 = new Player("Uhlrik Ubul", 70);
        Player testPlayer2 = new Player("Ujjatek Odon", 50);
        Player testPlayer3 = new Player("Kettes Kalman", 30);
        Player testPlayer4 = new Player("Tesztelo Tamas", 10);

        sortedList.add(testPlayer1);
        sortedList.add(testPlayer2);
        sortedList.add(testPlayer3);
        sortedList.add(testPlayer4);

        ScoreList testList2 = new ScoreList();
        testList2.add(testPlayer3);
        testList2.add(testPlayer2);
        testList2.add(testPlayer4);
        testList2.add(testPlayer1);

        testList2.sort();
        Assert.assertEquals(testList2, sortedList);

    }
}