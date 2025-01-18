import java.lang.String;
public class PrototypeExample {
    PrototypeExample example = new PrototypeExample().deepCopy();
    public static void main(String[] args) {
    }

    public PrototypeExample deepCopy() {
        return new PrototypeExample();
    }
}