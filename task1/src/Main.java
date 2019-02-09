import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        //InputStream inputStream = new FileInputStream("C:\\All_labs\\Course3\\TransAndComp\\task1\\expr.txt");
        BufferedReader reader = new BufferedReader(new FileReader("C:\\All_labs\\Course3\\TransAndComp\\task1\\expr.txt"));
        //File myExpr = new File("expr1.txt");
        //FileReader reader = new FileReader(myExpr);
        Lexer lexer = new Lexer(reader);
        String string = lexer.GetNextLexeme();
        while (!string.equals("EOF")) {
            System.out.println(string);
            string = lexer.GetNextLexeme();
        }
    }
}

