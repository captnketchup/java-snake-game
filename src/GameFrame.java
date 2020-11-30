import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame {
    //    private MenuPanel menuPanel;
    public ScoreboardPanel scorePanel;
    public Player p;
    private final CardLayout layout;
    private final GamePanel gamePanel;

    GameFrame() {
        //init frame attributes
        this.setTitle("Kigyosch jatek");
        layout = new CardLayout();
        this.setLayout(layout);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(this.getPreferredSize().width + GamePanel.SCREEN_WIDTH, this.getPreferredSize().height + GamePanel.SCREEN_HEIGHT);     //gamePanel size + frame size as to not cut out fields
        setResizable(false);
        this.setLocationRelativeTo(null);
        MenuPanel menuPanel = new MenuPanel();
        this.add(menuPanel, "MENU");
        p = new Player("Felhasznalo Ferenc", 0);
        gamePanel = new GamePanel();
        this.add(gamePanel, "GAME");
        scorePanel = new ScoreboardPanel();
        this.add(scorePanel, "SCORE");
        AddListeners(menuPanel);
        this.pack();
    }

    //menu actionlisteners:
    private void AddListeners(MenuPanel menuPanel) {
        /*
         * MENU
         * */
        menuPanel.eXitButton.addActionListener(actionEvent -> {
            scorePanel.scoreList.writeScoreboard("src/Scoreboard.ser");
            GameFrame.this.processWindowEvent(new WindowEvent(GameFrame.this, WindowEvent.WINDOW_CLOSING));
        });

        menuPanel.startGameButton.addActionListener(actionEvent -> {
            layout.show(GameFrame.this.getContentPane(), "GAME");
            gamePanel.requestFocusInWindow();
            p = new Player(p.name, 0);
            gamePanel.setPlayer(p);
            gamePanel.startGame();
        });

        menuPanel.settingsButton.addActionListener(action -> {
            String newName = actionPerformed(action);
            p = new Player(newName, 0);
        });

        /*
         * SCOREBOARD
         * */
        menuPanel.scoreboardButton.addActionListener(actionEvent -> {
            scorePanel.refreshScoreboard();
            layout.show(GameFrame.this.getContentPane(), "SCORE");
        });

        this.scorePanel.backButton.addActionListener(actionEvent -> layout.first(GameFrame.this.getContentPane()));

        /*
         * GAMEPANEL
         * */
        this.gamePanel.backToMenuButton.addActionListener(actionEvent -> {
                    layout.show(GameFrame.this.getContentPane(), "MENU");
                    scorePanel.scoreList.add(p);
                }
        );
    }

    public String actionPerformed(java.awt.event.ActionEvent evt) {
        return JOptionPane.showInputDialog(this, "Input name", null);
    }
}