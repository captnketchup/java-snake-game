import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GameFrame extends JFrame {

    GameFrame(){
        this.add(new GamePanel());
        this.setTitle("Kigyosch jatek");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //no option for resizing window, as shown in documentation
        setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);


    }


}
