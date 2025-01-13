// CodeDao interface
public interface CodeDao {
    int getLatestCodeNumber();
    void updateCodeNumber(int newNumber);
}

// CodeDao implementation
public class CodeDaoImpl implements CodeDao {
    private int latestNumber; // declare the variable

    @Override
    public int getLatestCodeNumber() {
        // retrieve the latest code number from the database
        // for simplicity, return a dummy value
        latestNumber = 10;
        return latestNumber;
    }

    @Override
    public void updateCodeNumber(int newNumber) {
        // update the code number in the database
        // for simplicity, update the local variable
        latestNumber = newNumber;
    }

    public static void main(String[] args) {
        CodeDaoImpl codeDaoImpl = new CodeDaoImpl();
        System.out.println(codeDaoImpl.getLatestCodeNumber());
        codeDaoImpl.updateCodeNumber(20);
        System.out.println(codeDaoImpl.getLatestCodeNumber());
    }
}