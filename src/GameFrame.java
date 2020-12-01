import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame {
    private final CardLayout layout;
    private final GamePanel gamePanel;
    private final MenuPanel menuPanel;
    private final ScoreboardPanel scorePanel;
    private Player p;

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
        menuPanel = new MenuPanel();
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
            this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });

        menuPanel.startGameButton.addActionListener(actionEvent -> {
            layout.show(this.getContentPane(), "GAME");
            gamePanel.requestFocusInWindow();
            p = new Player(p.name, 0);
            gamePanel.setPlayer(p);
            gamePanel.startGame();
        });

        menuPanel.settingsButton.addActionListener(action -> {
            String newName = actionPerformed(action);
            String oldName = p.name;
            p = new Player(newName, 0);
            if (p.name == null) {
                p.name = oldName;
            }
        });

        /*
         * SCOREBOARD
         * */
        menuPanel.scoreboardButton.addActionListener(actionEvent -> {
            scorePanel.refreshScoreboard();
            layout.show(this.getContentPane(), "SCORE");
        });

        this.scorePanel.backButton.addActionListener(actionEvent -> layout.first(this.getContentPane()));

        /*
         * GAMEPANEL
         * */
        this.gamePanel.backToMenuButton.addActionListener(actionEvent -> {
                    layout.show(this.getContentPane(), "MENU");
                    scorePanel.scoreList.add(p);
                }
        );
    }

    public String actionPerformed(java.awt.event.ActionEvent evt) {
        return JOptionPane.showInputDialog(this, "Input name", null);
    }
}