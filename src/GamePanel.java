import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 600;
    public static final int UNIT_SIZE = 25;
    public static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 75;

    Apple a = new Apple();
    Snake s = new Snake();
    char direction = 'D';       //starting direction: down
    static boolean running = false;
    public static Timer timer;
    public static boolean rainbow = false;

    public void newApple(){}

    GamePanel(){
        //random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    public void startGame(){
        //Apple apple = new Apple();
        running = true;
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
            g.setColor(a.c);
            //Apple a = new Apple();
            g.fillOval(a.getX(), a.getY(), UNIT_SIZE, UNIT_SIZE);

            for (int i = 0; i < Snake.bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(Snake.x[i], Snake.y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    if(rainbow){
                        g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                        g.fillRect(Snake.x[i], Snake.y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                    else{
                        g.setColor(Snake.c);
                        g.fillRect(Snake.x[i], Snake.y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                }
            }

            g.setColor(Color.yellow);
            g.setFont(new Font("Courier", Font.BOLD, 30));
            FontMetrics fm = getFontMetrics(g.getFont());
            g.drawString("SCORE: " + Snake.score, (SCREEN_WIDTH - fm.stringWidth("SCORE: "+Snake.score))/2, g.getFont().getSize());

        }
        else    gameOver(g);
    }

    public void move(){
      for(int i = Snake.bodyParts; i>0; i--){
          Snake.x[i] = Snake.x[i-1];
          Snake.y[i] = Snake.y[i-1];
      }
        switch (direction) {
            case 'U' -> Snake.y[0] = Snake.y[0] - UNIT_SIZE;
            case 'D' -> Snake.y[0] = Snake.y[0] + UNIT_SIZE;
            case 'L' -> Snake.x[0] = Snake.x[0] - UNIT_SIZE;
            case 'R' -> Snake.x[0] = Snake.x[0] + UNIT_SIZE;
        }
    }
    public void checkApple(){
        //Random random = new Random();
        if(Snake.x[0] == a.getX() && Snake.y[0] == a.getY()){
            //apple is fastApple and makes the snake rainbowy and fast
            if(a.isFast){
                rainbow = true;
                timer.stop();
                timer.setDelay(50);
                timer.restart();

            }
            //apple is slowApple and makes the snake blue and slow
            else if(a.isSlow){
                Snake.c = new Color(10, 150, 200);
                rainbow = false;
                timer.stop();
                timer.setDelay(100);
                timer.restart();
            }
            //normal apple, resets the snake
            else {
                Snake.bodyParts++;
                Snake.score++;
                Snake.c = Color.GREEN;
                rainbow = false;
                timer.stop();
                timer.setDelay(75);
                timer.restart();
            }
            a = new Apple();
        }
    }
    //public void checkCollisions(){}
    public void gameOver(Graphics g){
        //Game over screen
        g.setColor(Color.red);
        g.setFont(new Font("Courier", Font.BOLD, 69));
        FontMetrics fm1 = getFontMetrics(g.getFont());
        g.drawString("GAME OVER", (SCREEN_WIDTH - fm1.stringWidth("GAME OVER"))/2, SCREEN_HEIGHT/2);

        //restart button
        JButton resetButton = new JButton();


        //displays score
        g.setColor(Color.yellow);
        g.setFont(new Font("Courier", Font.BOLD, 30));
        FontMetrics fm2 = getFontMetrics(g.getFont());
        g.drawString("SCORE: " + Snake.score, (SCREEN_WIDTH - fm2.stringWidth("SCORE: "+Snake.score))/2, (SCREEN_HEIGHT/2)+4*UNIT_SIZE);

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
        if(running){
            move();
            checkApple();
            s.checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(direction != 'R')    direction = 'L';
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L')    direction = 'R';
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D')    direction = 'U';
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U')    direction = 'D';
                    break;
            }
        }
    }
}
