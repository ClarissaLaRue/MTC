import java.io.IOException;
import java.io.Reader;

public class Lexer {
    private Reader reader;
    private int current;

    public Lexer(Reader reader) throws IOException {
        this.reader = reader;
        current = this.reader.read();
    }

    public String GetNextLexeme() throws Exception {
        StringBuilder buf = new StringBuilder();
        switch (current){
            case '(':
                current = reader.read();
                return "(";
            case ')':
                current = reader.read();
                return ")";
            case '+':
                current = reader.read();
                return "+";
            case '-':
                current = reader.read();
                return "-";
            case '*':
                current = reader.read();
                return "*";
            case '/':
                current = reader.read();
                return "/";
            case '^':
                current = reader.read();
                return "^";
            case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
                while (current >= '0' && current <= '9'){
                    buf.append((char) current);
                    current = reader.read();
                }
                return new String(buf);
            case -1:
                return new String("EOF");
            default:
                throw new Exception("lexer exeption");
        }
    }
}
