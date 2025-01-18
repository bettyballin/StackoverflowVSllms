import java.lang.String;
public class Main_365 {
    public static void main(String[] args) {
        int x = 36;
        int index =1 ;//starting with 0x01 not 0x0
        for (int i=0;i<x;i++){
            if(i==9*((i)/10)+9){
                String HexNumber = String.format("%02X", (index+5)%64);// +"%");
                System.out.println(HexNumber);
            }
            else{
                System.out.printf("%02X \n", index);
            }
            index++;
        }
    }
}