import java.lang.String;
public class TransactionManagerisasuitablenameforthisinterfaceasitaccuratelyreflectsitspurpose {
    public static interface TransactionManager {
       void beginTransaction();
       void commitTransaction();
       void rollbackTransaction();
    }

    public static void main(String[] args) {
    }
}