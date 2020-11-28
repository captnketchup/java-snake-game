import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GameFrame extends JFrame {
    private CardLayout layout;
    private GamePanel gamePanel;
    //private ScorePanel scorePanel;        //TODO: create a scoreboard

    GameFrame(){
        contPane = this.getContentPane();
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.setVisible(true);
        Menu menuPanel = new Menu();
        GamePanel gamePanel = new GamePanel();
//        this.add(menuPanel);
        this.add(gamePanel);
        gamePanel.addKeyListener(new GamePanel.MyKeyAdapter());
        //switches between panels using:
//        cardLayout.show(contPane, "MENU");

//        this.add(menuPanel);
//        this.add(gamePanel);
        this.setTitle("Kigyosch jatek");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //no option for resizing window, as shown in documentation
        setResizable(false);
        this.pack();
//        this.setVisible(true);
        this.setLocationRelativeTo(null);

        //menu actionlisteners:
        menuPanel.startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPane, "GAME");
            }
        });
        menuPanel.settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        menuPanel.scoreboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        menuPanel.eXitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
