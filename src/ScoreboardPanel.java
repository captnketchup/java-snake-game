import javax.swing.*;
import java.awt.*;

public class ScoreboardPanel extends JPanel {
    JLabel title;
    ScoreList scoreList;
    JButton backButton;
    JList<String> scoreJList;
    DefaultListModel<String> listModel;

    public ScoreboardPanel() {
        super();
        this.setBackground(Color.BLACK);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setTitle();
        scoreList = ScoreList.readScoreboard("src/Scoreboard.ser");
        listModel = new DefaultListModel<>();
        scoreJList = new JList<>(listModel);
        scoreJList.setFont(new Font("Courier", Font.PLAIN, 30));
        scoreJList.setBackground(Color.BLACK);
        scoreJList.setForeground(Color.WHITE);
        this.add(scoreJList);
        setButton();
    }


    public void refreshScoreboard() {
        scoreList.sort();
        listModel.clear();
        for (int i = 0; i < 10 && i < scoreList.size(); i++) {
            listModel.addElement(scoreList.get(i).toString());
        }
    }

    private void setTitle() {
        JPanel boxLayout = new JPanel();
        boxLayout.setLayout(new BoxLayout(boxLayout, BoxLayout.X_AXIS));
        title = new JLabel("Scoreboard", SwingConstants.LEFT);
        title.setForeground(Color.WHITE);
        boxLayout.setBackground(Color.BLACK);
        title.setFont(new Font("Courier", Font.PLAIN, 50));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        boxLayout.add(title);
        this.add(boxLayout);
    }

    private void setButton() {
        JPanel boxLayout = new JPanel();
        boxLayout.setLayout(new BoxLayout(boxLayout, BoxLayout.X_AXIS));
        backButton = new JButton("Back");
        boxLayout.add(backButton);
        this.add(boxLayout);
    }
}

