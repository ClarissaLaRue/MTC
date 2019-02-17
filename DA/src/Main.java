import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("C:\\All_labs\\Course3\\TransAndComp\\DA\\src\\data.txt");
        FileReader lineReader = new FileReader("C:\\All_labs\\Course3\\TransAndComp\\DA\\src\\line.txt");
        Parser parser = new Parser(reader);
        try {
            if (parser.getAytomaton().recognize(lineReader) == true){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }

        }catch (ParserException e) {
            System.out.println(e.mes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
