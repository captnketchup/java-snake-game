import java.awt.*;

public class Snake {
    public static final int x[] = new int[GamePanel.GAME_UNITS];
    public static final int y[] = new int[GamePanel.GAME_UNITS];
    static int bodyParts = 6;
    public static int score;
    public static Color c = new Color(69, 255, 69);

    Snake(){}
    public int getbodyParts(){
        return bodyParts;
    }
    public void checkCollisions(){
        //checks if head collides w/ body
        for(int i = bodyParts; i > 0; i--){
            if((x[0] == x[i] && y[0] == y[i])) {
                GamePanel.setRunning(false);
            }
        }
        //checks if head collides w/ left border
        if(x[0] < 0)    GamePanel.setRunning(false);

        //checks if head collides w/ right border
        if(x[0] > GamePanel.SCREEN_WIDTH)   GamePanel.setRunning(false);

        //checks if head collides w/ upper border
        if(y[0] < 0)    GamePanel.setRunning(false);

        //checks if head collides w/ downer border
        if(y[0] > GamePanel.SCREEN_HEIGHT)  GamePanel.setRunning(false);

        if(!GamePanel.isRunning()){
            GamePanel.timer.stop();
        }
    }
}
