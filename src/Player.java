import java.io.*;
import java.lang.*;
import java.util.*;

public class Player implements Serializable{
    String name;
    int score;

    public Player(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + " " + score;
    }

//
//    public int compareTo(Player comparesto) {
//        int compareScore = (comparesto.score);
//        return this.score-compareScore;
//    }
}



//class Sortbyscore implements Comparator<Player>{
//    public int compare(Player a, Player b){
//        return Integer.compare(a.score, b.score);
//    }
//}
