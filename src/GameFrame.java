import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame {
    private CardLayout layout;
    private GamePanel gamePanel;
//    private MenuPanel menuPanel;
    //private ScorePanel scorePanel;        //TODO: create a scoreboard

    GameFrame() {
        this.setTitle("Kigyosch jatek");
        layout = new CardLayout();
        this.setLayout(layout);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT);
        setResizable(false);
        this.setLocationRelativeTo(null);
        MenuPanel menuPanel = new MenuPanel();
        this.add(menuPanel);
        gamePanel = new GamePanel(this);
        this.add(gamePanel);
//        gamePanel = new GamePanel();
//        this.add(gamePanel);
        AddListeners(menuPanel);
        //might need to add frame as owner?


//        gamePanel.addKeyListener(new GamePanel.MyKeyAdapter());
        //switches between panels using:
//        cardLayout.show(contPane, "MENU");

//        this.add(menuPanel);
//        this.add(gamePanel);
        //no option for resizing window, as shown in documentation
//        this.pack();
//        this.setVisible(true);
    }

    //menu actionlisteners:
    private void AddListeners(MenuPanel menuPanel) {
        menuPanel.eXitButton.addActionListener(actionEvent -> GameFrame.this.processWindowEvent(
                new WindowEvent(GameFrame.this, WindowEvent.WINDOW_CLOSING)
        ));

        menuPanel.startGameButton.addActionListener(actionEvent -> {
            layout.next(GameFrame.this.getContentPane());
            gamePanel.requestFocusInWindow();
            gamePanel.startGame();
        });

//        menuPanel.settingsButton.addActionListener();

//        menuPanel.scoreboardButton.addActionListener();

    }

    //game listeners:
//    private void addKeyListenerToFrame() {
//        this.gamePanel.addKeyListener(new MyKeyAdapter(gamePanel));
//    }
//
//    public static class MyKeyAdapter extends KeyAdapter{
//        GamePanel gamePanel;
//        public MyKeyAdapter(GamePanel gp) {
//            gamePanel = gp;
//        }
//
//        @Override
//        public void keyPressed(KeyEvent e){
//            //gets controlls works via arrow keys or WASD
//            System.out.println("last key pressed lefut");
//            GamePanel.lastKeyPressed = e.getKeyCode();
//        }
//    }
}

