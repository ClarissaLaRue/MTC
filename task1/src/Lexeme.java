public class Lexeme {
    private String lex;
    private String type;

    public Lexeme(String lex, String type){
        this.lex = lex;
        this.type = type;
    }

    public String getLex(){
        return lex;
    }

    public String getType(){
        return type;
    }
}
