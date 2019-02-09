public class Parser {
    private Lexer lexer;
    private String currant;

    public Parser(Lexer lexer) throws Exception {
        this.lexer = lexer;
        currant = this.lexer.GetNextLexeme();
    }

}
