import java.awt.*;
import java.awt.event.KeyEvent;

enum Direction {UP, DOWN, LEFT, RIGHT}


public class Snake {
    final int x[] = new int[GamePanel.GAME_UNITS];      //TODO: move to snacc contructor
    final int y[] = new int[GamePanel.GAME_UNITS];
    int bodyParts = 2;
    int score;
    Color c = new Color(69, 255, 69);
    Direction direction = Direction.DOWN;
    Direction nextDirection;

    Snake(){}
    public void changeDirection(Direction inDirection){
        switch (direction) {
            case LEFT:
                if (inDirection != Direction.RIGHT ) nextDirection = inDirection;
                break;
            case RIGHT:
                if (inDirection != Direction.LEFT) nextDirection = inDirection;
                break;
            case UP:
                if (inDirection != Direction.DOWN) nextDirection = inDirection;
                break;
            case DOWN:
                if (inDirection != Direction.UP) nextDirection = inDirection;
                break;
        }
    }

    public void move(){
        //shifts body parts one by one
        for(int i = bodyParts; i>0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        switch (direction) {
            case UP -> y[0] = y[0] - GamePanel.UNIT_SIZE;
            case DOWN -> y[0] = y[0] + GamePanel.UNIT_SIZE;
            case LEFT -> x[0] = x[0] - GamePanel.UNIT_SIZE;
            case RIGHT -> x[0] = x[0] + GamePanel.UNIT_SIZE;
        }
    }

    public int getbodyParts(){
        return bodyParts;
    }
    public boolean checkCollisions(){      //checks if collision occurs:
        //with its body
        for(int i = bodyParts; i > 0; i--){
            if((x[0] == x[i] && y[0] == y[i])) {
                return true;
            }
        }
        //with left border
        if(x[0] < 0)
            return true;

        //with right border
        if(x[0] > GamePanel.SCREEN_WIDTH - GamePanel.UNIT_SIZE)
            return true;

        //with upper border
        if(y[0] < 0)
            return true;

        //with downer border
        if(y[0] > GamePanel.SCREEN_HEIGHT - GamePanel.UNIT_SIZE)
            return true;
        return false;
//        if(!GamePanel.isRunning()){
//            GamePanel.timer.stop();
//        }
    }
}
