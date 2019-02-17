public class AutomatonException extends Exception {
    String mes = "OK";

    public AutomatonException(String string){
        mes = string;
    }

    public String getMes(){
        return mes;
    }
}
