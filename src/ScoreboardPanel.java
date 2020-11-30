import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CompletionException;

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
//        refreshScoreboard();
        scoreList = ScoreList.readScoreboard("src/Scoreboard.ser");
        listModel = new DefaultListModel<>();
        scoreJList = new JList<>(listModel);
//        scoreJList.setBounds(GamePanel.SCREEN_WIDTH / 2 - 150, (GamePanel.SCREEN_HEIGHT / 2) + 10 * GamePanel.UNIT_SIZE, 300, 100);
        scoreJList.setFont(new Font("Courier", Font.PLAIN, 30));
        scoreJList.setBackground(Color.BLACK);
        scoreJList.setForeground(Color.WHITE);
        scoreJList.setVisibleRowCount(10);
//        scoreJList.setAlignmentX(Component.CENTER_ALIGNMENT);
//        DefaultListCellRenderer renderer = (DefaultListCellRenderer) scoreJList.getCellRenderer();
//        renderer.setHorizontalAlignment(SwingConstants.CENTER);
//        renderer.setFocusable(false);
//        renderer.setVisible(true);
//        this.add(renderer);
        this.add(scoreJList);
        setButton();
    }


    public void refreshScoreboard() {
        scoreList.data.sort((player1, player2) -> {            //sorts arraylist by score values
            return player2.score - player1.score;
        });

        listModel.clear();
        for (Player p : scoreList.data) {
            listModel.addElement(p.toString());
        }
    }

    private void setTitle() {
        JPanel boxLayout = new JPanel();
        boxLayout.setLayout(new BoxLayout(boxLayout, BoxLayout.X_AXIS));
        title = new JLabel("Scoreboard", SwingConstants.LEFT);
//        title.setBackground(Color.RED);
        title.setForeground(Color.WHITE);
        boxLayout.setBackground(Color.BLACK);
        title.setFont(new Font("Courier", Font.PLAIN, 50));
        FontMetrics fm = getFontMetrics(title.getFont());
//        title.setBounds((GamePanel.SCREEN_WIDTH-200)/2, 50, 500, 130);
        title.setHorizontalAlignment(SwingConstants.CENTER);
//        title.setAlignmentX(Component.CENTER_ALIGNMENT - fm.stringWidth("Scoreboard") / 2);
        boxLayout.add(title);
        this.add(boxLayout);
//        this.add(Box.createHorizontalGlue());
//        this.add(title);
//        this.add(Box.createHorizontalGlue());
    }

    private void setButton() {
        JPanel boxLayout = new JPanel();
        boxLayout.setLayout(new BoxLayout(boxLayout, BoxLayout.X_AXIS));
        backButton = new JButton("Back");
        //backButton.setBounds((GamePanel.SCREEN_WIDTH-200)/2, 590, 80, 30);
//        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boxLayout.add(backButton);
        this.add(boxLayout);
    }
}

