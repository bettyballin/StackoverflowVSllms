public class MainClass {
    public static byte getByteValue(char c) {
        byte value = 0; 

        switch(c) { 
           case '0': 
                 value = 0;
                 break;             
           case '1':
                 value = 1;
                 break;
           case '2':
                 value = 2;
                 break;
           case '3':
                 value = 3;
                 break;
           case '4':
                 value = 4;
                 break;
           case '5':
                 value = 5;
                 break;
           case '6':
                 value = 6;
                 break;
           case '7':
                 value = 7;
                 break;
           case '8':
                 value = 8;
                 break;
           case '9':
                 value = 9;
                 break;
           default:
                 throw new UnsupportedOperationException("Unsupported character " + c);
        }
        return value;
    }
}