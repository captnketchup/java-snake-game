import java.io.*;
import java.util.ArrayList;

public class ScoreList extends ArrayList<Player> implements Serializable {
    public void sort(){
        this.sort((player1, player2) -> {            //sorts arraylist by score values
            return player2.score - player1.score;
        });
    }

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
