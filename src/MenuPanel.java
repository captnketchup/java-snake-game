import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    public JPanel Menu0;
    JButton startGameButton;
    JButton settingsButton;
    JButton scoreboardButton;
    JButton eXitButton;

    public MenuPanel() {
        super();
        this.setSize(GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT);
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        setUpAllButtons();

    }

    private void setUpAllButtons() {
        setUpStartGameButton();
        setUpSettingsButton();
        setUpScoreboardButton();
        setUpeXitButton();
    }

    private void setUpeXitButton() {
        eXitButton = new JButton("Exit");
        eXitButton.setBounds((GamePanel.SCREEN_WIDTH - 200) / 2, 425, 200, 50); //?
        this.add(eXitButton);
    }

    private void setUpScoreboardButton() {
        scoreboardButton = new JButton("Scoreboard");
        scoreboardButton.setBounds((GamePanel.SCREEN_WIDTH - 200) / 2, 350, 200, 50); //?;
        this.add(scoreboardButton);
    }

    private void setUpSettingsButton() {
        settingsButton = new JButton("Change name");
        settingsButton.setBounds((GamePanel.SCREEN_WIDTH - 200) / 2, 270, 200, 50); //?
        this.add(settingsButton);
    }

    private void setUpStartGameButton() {
        startGameButton = new JButton("Start Game");
        startGameButton.setBounds((GamePanel.SCREEN_WIDTH - 200) / 2, 200, 200, 50); //?
        this.add(startGameButton);
    }
}
