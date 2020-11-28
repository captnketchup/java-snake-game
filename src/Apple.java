import java.awt.*;
import java.util.Random;

public class Apple {
    int x;
    int y;
    Random random;
    boolean isFast = false;
    boolean isSlow = false;
    public Color c = new Color(255, 0, 0);

    Apple(){
        //gives apple a random coordinate
        random = new Random();
        x = random.nextInt((int)(GamePanel.SCREEN_WIDTH/GamePanel.UNIT_SIZE))*GamePanel.UNIT_SIZE;
        y = random.nextInt((int)(GamePanel.SCREEN_HEIGHT/GamePanel.UNIT_SIZE))*GamePanel.UNIT_SIZE;
        //generates a random number, so it may result in special apple
        Random r = new Random();
        int n = (r.nextInt(10));

        //go fast apple
        if(n < 2) {
            isFast = true;
            c = Color.yellow;
        }
        //go slow apple
        else if(n < 4) {
            isSlow = true;
            c = Color.blue;
        }
    }

    public int getX(){ return x; }
    public int getY(){ return y; }

}
