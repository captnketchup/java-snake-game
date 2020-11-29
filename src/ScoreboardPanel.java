import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ScoreboardPanel extends JPanel {
    JLabel title;
    JList<String> playerList;
    JButton backButton;

    public ScoreboardPanel() {
        super();
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        setTitle();
        setButton();
    }


    public void showScoreboard() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        ArrayList<Player> list = Player.readScoreBoard();
        for(Player p : list){
            listModel.addElement(p.toString());
        }
        playerList = new JList<>(listModel);
        playerList.setBounds((GamePanel.SCREEN_WIDTH-200)/2, 190, 500, 400);
        playerList.setFont(new Font("Courier", Font.PLAIN, 20));
        playerList.setBackground(Color.BLACK);
        playerList.setForeground(Color.WHITE);
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) playerList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
//        renderer.setVerticalAlignment(SwingConstants.CENTER);
        renderer.setFocusable(false);
        this.add(playerList);
    }

    private void setTitle() {
        title = new JLabel("Scoreboard");
        title.setBackground(Color.BLACK);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Courier", Font.PLAIN, 50));
        title.setBounds((GamePanel.SCREEN_WIDTH-200)/2, 50, 500, 130);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title);
    }

    private void setButton() {
        backButton = new JButton("Back");
        backButton.setBounds((GamePanel.SCREEN_WIDTH-200)/2, 590, 80, 30);
        this.add(backButton);
    }
}
