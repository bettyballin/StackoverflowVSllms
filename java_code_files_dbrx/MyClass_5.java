public class MyClass {
    private FormFile file1;
    private FormFile file2;

    // Getters and setters for each property
    public void setFile1(FormFile file1) {
        this.file1 = file1;
    }

    public FormFile getFile1() {
        return this.file1;
    }

    public void setFile2(FormFile file2) {
        this.file2 = file2;
    }

    public FormFile getFile2() {
        return this.file2;
    }

    public static void main(String[] args) {
        // Example usage
        MyClass myClass = new MyClass();
        myClass.setFile1(new FormFile());
        myClass.setFile2(new FormFile());
        System.out.println("File1: " + myClass.getFile1());
        System.out.println("File2: " + myClass.getFile2());
    }
}

class FormFile {
    // Minimal implementation to make the code executable
}