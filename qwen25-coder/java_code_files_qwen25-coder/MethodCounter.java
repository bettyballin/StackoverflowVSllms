// Example of an ASM visitor that counts the number of methods
public class MethodCounter extends ClassVisitor {
    private int count = 0;

    public MethodCounter(ClassVersion cv) {
        super(cv.api);
    }

    @Override
    public MethodVisitor visitMethod(
            final int access,
            final String name,
            final String descriptor,
            final String signature,
            final String[] exceptions) {
        ++count;
        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }
}

class ClassVisitor {
    public ClassVisitor(int api) {
    }

    public MethodVisitor visitMethod(
        int access,
        String name,
        String descriptor,
        String signature,
        String[] exceptions) {
        return new MethodVisitor();
    }
}

class MethodVisitor {
    public MethodVisitor() {
    }
}

class ClassVersion {
    public int api;
    public ClassVersion(int api) {
        this.api = api;
    }
}

public class Main {
    public static void main(String[] args) {
    }
}