import java.io.*;
import java.util.ArrayList;

public class ScoreList implements Serializable {
    public ArrayList<Player> data = new ArrayList<>();

    public static ScoreList readScoreboard(String fname) {
        ScoreList scoreList = new ScoreList();
        try {
            File f = new File(fname);
            FileInputStream fs = new FileInputStream(f);
            ObjectInputStream is = new ObjectInputStream(fs);
            scoreList = (ScoreList) is.readObject();
            is.close();
            fs.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return scoreList;
    }

    public void add(Player player) {
        data.add(player);
    }

    public void writeScoreboard(String fname) {
        try {
            FileOutputStream fs = new FileOutputStream(fname);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(this);
            os.close();
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
