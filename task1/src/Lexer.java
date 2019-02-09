import java.io.IOException;
import java.io.Reader;

public class Lexer {
    private Reader reader;
    private int current;

    public Lexer(Reader reader) throws IOException {
        this.reader = reader;
        current = this.reader.read();
    }

    public Lexeme GetNextLexeme() throws Exception {
        StringBuilder buf = new StringBuilder();
        switch (current){
            case '(':
                current = reader.read();
                return new Lexeme(Parser.OPEN, Parser.OPEN);
            case ')':
                current = reader.read();
                return new Lexeme(Parser.CLOSE, Parser.CLOSE);
            case '+':
                current = reader.read();
                return new Lexeme(Parser.PLUS, Parser.PLUS);
            case '-':
                current = reader.read();
                return new Lexeme(Parser.MINUS, Parser.MINUS);
            case '*':
                current = reader.read();
                return new Lexeme(Parser.MULT, Parser.MULT);
            case '/':
                current = reader.read();
                return new Lexeme(Parser.DIV, Parser.DIV);
            case '^':
                current = reader.read();
                return new Lexeme(Parser.POW, Parser.POW);
            case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
                while (current >= '0' && current <= '9'){
                    buf.append((char) current);
                    current = reader.read();
                }
                return new Lexeme(new String(buf), Parser.NUM);
            case -1:
                return new Lexeme(new String("EOF"), Parser.EOF);
            default:
                throw new Exception("lexer exeption");
        }
    }
}
