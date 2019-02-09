public class Parser {
    static String MINUS = "-";
    static String PLUS = "+";
    static String MULT = "*";
    static String DIV = "/";
    static String OPEN = "(";
    static String CLOSE = ")";
    static String POW = "^";
    static String NUM = "num";
    static String EOF = "eof";

    private Lexer lexer;
    private Lexeme currant;

    public Parser(Lexer lexer) throws Exception {
        this.lexer = lexer;
        currant = this.lexer.GetNextLexeme();
    }

    public int parseExpr() throws Exception {
        int term = parseTerm();
        while ((currant.getType() == MINUS) || (currant.getType() == PLUS)){
            if (currant.getType() == MINUS){
                currant = lexer.GetNextLexeme();
                term -= parseTerm();
            }
            if (currant.getType() == PLUS){
                currant = lexer.GetNextLexeme();
                term += parseTerm();
            }
        }
        return term;
    }

    public int parseTerm() throws Exception {
        int factor = parseFactor();
        while ((currant.getType() == MULT) || (currant.getType() == DIV)){
            if (currant.getType() == MULT){
                currant = lexer.GetNextLexeme();
                factor *= parseFactor();
            }
            if (currant.getType() == DIV){
                currant = lexer.GetNextLexeme();
                factor /= parseFactor();
            }
        }
        return factor;
    }

    public int parseFactor() throws Exception {
        int power = parsePower();
        if (currant.getType() == POW){
            currant = lexer.GetNextLexeme();
            power = (int) Math.pow(power, parseFactor());
        }
        return power;
    }

    public int parsePower() throws Exception {
        if (currant.getType() == MINUS){
            currant = lexer.GetNextLexeme();
            return -parseAtom();
        }
        return parseAtom();
    }

    public int parseAtom() throws Exception {
        if(currant.getType() == NUM){
            int tmp = Integer.parseInt(currant.getLex());
            currant = lexer.GetNextLexeme();
            return tmp;
        }
        if(currant.getType() == OPEN){
            currant = lexer.GetNextLexeme();
            int tmp = parseExpr();
            if(currant.getType() != CLOSE){
                throw new Exception("Parser exeption");
            }else {
                currant = lexer.GetNextLexeme();
                return tmp;
            }
        }
        throw new Exception("Parser exeption");
    }

}
