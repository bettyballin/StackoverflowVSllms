import java.lang.String;
public class ArrayUtil {
    // Manual Loop copy alternative to memmove
    public static void safeMemMove(byte[] b, int sI, int dI) {
        if (sI == dI) return; // If the source and destination are the same then just do nothing
        byte buffer = 0;
        if (dI < sI) {
            for (int i = dI - 1, j = sI + (dI - sI); i >= 0; --i, j++) { // Copy the portion before destination
                 buffer = b[j];
                b[j] = b[i];
                b[i] = buffer;
            }
        } else if (sI < dI) {
          for(int i= sI ; i <=dI && i<b.length; ++i){//copy destination values to buffer before overwriting them
           buffer = b[i];
           b[i] = sI>=0&&sI<=dI?b[sI++]:buffer; //if you have not reach the source index just keep its value else copy from src array
          }
        }
    }
    	public static void main(String[] args) {
    	}
}