public class ParserException extends Exception {
    String mes = "OK";

    public ParserException(String string){
        mes = string;
    }

    public String getMes(){
        return mes;
    }
}
