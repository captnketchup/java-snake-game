import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 75;
    static int lastKeyPressed;

    Apple a;
    Snake s;
    //char direction = 'D';       //starting direction: down
    static boolean running = false;
    public static Timer timer;
    public static boolean rainbow = false;

//    public void newApple(){}

    GamePanel(){
        //random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
//        this.addKeyListener(new MyKeyAdapter());
        startGame();        //TODO:move to frame startgame
    }
    public void startGame(){
        //Apple apple = new Apple();
        a = new Apple();
        s = new Snake();
        running = true;
        if(timer != null) timer.stop();         //shuts down previous timer to prevent interference
        timer = new Timer(DELAY, this);
        timer.start();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        Random random = new Random();
        if(running) {
            //draws a matrix
            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            }
            //draws an apple
            g.setColor(a.c);
            g.fillOval(a.getX(), a.getY(), UNIT_SIZE, UNIT_SIZE);


            //draws snake
            for (int i = 0; i < s.bodyParts; i++) {
                //if head of snake
                if (i == 0) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(s.x[i], s.y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    if(rainbow){
                        g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                        g.fillRect(s.x[i], s.y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                    else{
                        g.setColor(s.c);
                        g.fillRect(s.x[i], s.y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                }
            }

//            g.setColor(Color.yellow);
//            g.setFont(new Font("Courier", Font.BOLD, 30));
//            FontMetrics fm = getFontMetrics(g.getFont());
//            g.drawString("SCORE: " + Snake.score, (SCREEN_WIDTH - fm.stringWidth("SCORE: "+Snake.score))/2, g.getFont().getSize());

        }
        else gameOver(g);
    }


    //moved to snake class
//    public void move(){
//        //shifts body parts one by one
//      for(int i = s.bodyParts; i>0; i--){
//          s.x[i] = s.x[i-1];
//          s.y[i] = s.y[i-1];
//      }
//        switch (s.direction) {
//            case UP -> s.y[0] = s.y[0] - UNIT_SIZE;
//            case DOWN -> s.y[0] = s.y[0] + UNIT_SIZE;
//            case LEFT -> s.x[0] = s.x[0] - UNIT_SIZE;
//            case RIGHT -> s.x[0] = s.x[0] + UNIT_SIZE;
//        }
//    }
    public void checkApple(){
        //Random random = new Random();
        if(s.x[0] == a.getX() && s.y[0] == a.getY()){
            //apple is fastApple and makes the snake rainbowy and fast
            if(a.isFast){
                rainbow = true;
                timer.stop();
                timer.setDelay(50);
                timer.restart();

            }
            //apple is slowApple and makes the snake blue and slow
            else if(a.isSlow){
                s.c = new Color(10, 150, 200);
                rainbow = false;
                timer.stop();
                timer.setDelay(100);
                timer.restart();
            }
            //normal apple, resets the snake
            else {
                s.bodyParts++;
                s.score++;
                s.c = Color.GREEN;
                rainbow = false;
                timer.stop();
                timer.setDelay(75);
                timer.restart();
            }
            a = new Apple();
        }
    }

    public void gameOver(Graphics g){
        //Game over screen
        g.setColor(Color.red);
        g.setFont(new Font("Helvetica", Font.BOLD, 69));
        FontMetrics fm1 = getFontMetrics(g.getFont());
        g.drawString("GAME OVER", (SCREEN_WIDTH - fm1.stringWidth("GAME OVER"))/2, SCREEN_HEIGHT/2);

        //restart game
        g.setColor(Color.white);
        g.setFont(new Font("Helvetica", Font.ITALIC, 20));
        FontMetrics fm2 = getFontMetrics(g.getFont());
        g.drawString("PRESS ENTER TO REPLAY", (SCREEN_WIDTH - fm2.stringWidth("PRESS ENTER TO REPLAY"))/2, (SCREEN_HEIGHT/2)+8*UNIT_SIZE);
        g.drawString("PRESS ESC TO GO TO MAIN MENU", (SCREEN_WIDTH - fm2.stringWidth("PRESS ESC TO GO TO MAIN MENU"))/2, (SCREEN_HEIGHT/2)+10*UNIT_SIZE);

        //displays score
        g.setColor(Color.yellow);
        g.setFont(new Font("Helvetica", Font.BOLD, 30));
        FontMetrics fm3 = getFontMetrics(g.getFont());
        g.drawString("SCORE: " + s.score, (SCREEN_WIDTH - fm3.stringWidth("SCORE: "+s.score))/2, (SCREEN_HEIGHT/2)+4*UNIT_SIZE);

        //??
    }

    public static void setRunning(boolean b){
        running = b;
    }

    public static boolean isRunning(){
        return running;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){            //registers keyevents during game
                switch (lastKeyPressed) {
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_A:
                        if (s.direction != Direction.RIGHT) s.direction = Direction.LEFT;
                        break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:
                        if (s.direction != Direction.LEFT) s.direction = Direction.RIGHT;
                        break;
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:
                        if (s.direction != Direction.DOWN) s.direction = Direction.UP;
                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        if (s.direction != Direction.UP) s.direction = Direction.DOWN;
                        break;
                }
            s.move();
            checkApple();
            s.checkCollisions();
        }
        //game over scenario
        else{
            switch (lastKeyPressed) {
                case KeyEvent.VK_ENTER:
                    startGame();
                case KeyEvent.VK_ESCAPE:
                    //TODO: return to main menu
            }
        }
        repaint();
    }

    public static class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            //gets controlls works via arrow keys or WASD
            System.out.println("last key pressed lefut");
            lastKeyPressed = e.getKeyCode();
        }
    }
}
