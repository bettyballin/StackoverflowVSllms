import com.jacob.activeX.ActiveXComponent;

public class Main_436 {
    public static void main(String[] args) {
        ActiveXComponent vbProgram = new ActiveXComponent("Your.VB.Program");
        vbProgram.invoke("YourMethod");
    }
}