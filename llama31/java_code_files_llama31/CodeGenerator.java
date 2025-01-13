/*
 * Decompiled with CFR 0.152.
 */
public class CodeGenerator {
    private CodeDao codeDao;

    public CodeGenerator(CodeDao codeDao) {
        this.codeDao = codeDao;
    }

    public String generateCode() {
        int n = this.codeDao.getLatestCodeNumber();
        int n2 = n + 1;
        this.codeDao.updateCodeNumber(n2);
        return "ABCD" + n2;
    }

    public static void main(String[] stringArray) {
        CodeDao codeDao = new CodeDao();
        CodeGenerator codeGenerator = new CodeGenerator(codeDao);
        String string = codeGenerator.generateCode();
        System.out.println("Generated Code: " + string);
    }
}
