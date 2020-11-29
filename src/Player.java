import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class Player {

    String name;
    int score;

    public Player(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return score + " " + name;
    }

    public static ArrayList<Player> readScoreBoard() {
        ArrayList<Player> scoreBoard = new ArrayList<>();
        try{
            FileReader fr = new FileReader("src/Scoreboard.txt");
            BufferedReader br = new BufferedReader(fr);
            for (int i = 0; i < 10; i++){
                Player p = new Player("", 0);
                p.loadFromText(br);
                scoreBoard.add(p);
                br.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return scoreBoard;
    }

    public static void writeScoreboard(ArrayList<Player> scoreboard){
        scoreboard.sort(Comparator.comparingInt(player -> -player.score));
        try{
            FileWriter fw = new FileWriter("src/Scoreboard.txt");
            for (int i = 0; i < 10; i++){
                scoreboard.get(i).saveToText(fw);
            }
            fw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public void saveToText(FileWriter fw){
        try{
            fw.write(this.score + ";" + this.name + "\n");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadFromText(BufferedReader br) {
        String line = null;
        try {
            line = br.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        if (line == null){
            return;
        }
        String[] tokens = line.split(";");
        this.score = Integer.parseInt(tokens[0]);
        this.name = tokens[1];
    }
}
