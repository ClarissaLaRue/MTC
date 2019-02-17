import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

public class Parser {
    Reader reader;
    ArrayList<Integer> finishState = new ArrayList<>();
    HashMap<Integer, HashMap<Character, Integer>> rules = new HashMap<>();

    public Parser(Reader reader){
        this.reader = reader;
    }

    public Automaton getAytomaton() throws IOException, ParserException {
        int c;
        c = reader.read();
        while (c != '\r'){
            finishState.add(c);
            c = reader.read();
        }
        c = reader.read();
        c = reader.read();
        int start;
        int rule;
        int finish;
        while (c != -1){
            start = c;
            rule = reader.read();
            if (rule == -1){
                throw new ParserException("incorrectly written transition rules");
            }
            finish = reader.read();
            if (finish == -1){
                throw new ParserException("incorrectly written transition rules");
            }
            HashMap<Character, Integer> map = new HashMap<>();
            map.put((char)rule, finish);
            rules.put(start, map );
            for (int i = 0;i < 3; i ++){
                c = reader.read();
            }
        }
        Automaton automaton = new Automaton(finishState, rules);
        return automaton;
    }
}
