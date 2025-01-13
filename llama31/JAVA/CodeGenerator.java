// Define a simple CodeDao class for demonstration
class CodeDao {
    private int latestCodeNumber = 0; // Initialize with 0 for simplicity

    public int getLatestCodeNumber() {
        return latestCodeNumber;
    }

    public void updateCodeNumber(int newNumber) {
        this.latestCodeNumber = newNumber;
    }
}

public class CodeGenerator {
    private CodeDao codeDao;

    public CodeGenerator(CodeDao codeDao) {
        this.codeDao = codeDao;
    }

    public String generateCode() {
        int latestNumber = codeDao.getLatestCodeNumber();
        int newNumber = latestNumber + 1;
        codeDao.updateCodeNumber(newNumber);
        return "ABCD" + newNumber;
    }

    public static void main(String[] args) {
        // Create an instance of CodeDao
        CodeDao codeDao = new CodeDao();
        
        // Create an instance of CodeGenerator with the CodeDao instance
        CodeGenerator codeGenerator = new CodeGenerator(codeDao);
        
        // Generate and print a new code
        String newCode = codeGenerator.generateCode();
        System.out.println("Generated Code: " + newCode);
    }
}