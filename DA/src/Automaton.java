import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

public class Automaton {
    static private int START = '0';
    private ArrayList<Integer> finishState;
    private HashMap<Integer, HashMap<Character, Integer>> rules;

    public Automaton(ArrayList finishState, HashMap rules){
        this.finishState = finishState;
        this.rules = rules;
    }

    public Boolean recognize(Reader reader) throws IOException {
        int c = reader.read();
        int start = START;
        int finish = 0;
        int rule;
        while (c != -1){
            finish = rules.get(start).get((char)c);
            start = finish;
            c = reader.read();
        }
        if (finishState.contains(finish)){
            return true;
        }else{
            return false;
        }
    }
}
