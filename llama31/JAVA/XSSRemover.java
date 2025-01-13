import java.lang.String;

public class XSSRemover {
    public void removeXSS(){
        String s = "http://www.google.com";
        if(s.toLowerCase().contains("javascript:")){
            //TODO: implement XSS remove code.
            s = s.substring(s.indexOf(':') + 1);
            System.out.println("s = " + s);
        }
    }

    public static void main(String[] args) {
        XSSRemover remover = new XSSRemover();
        remover.removeXSS();
    }
}