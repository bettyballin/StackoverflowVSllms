import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class A_8_8 {
    @Getter
    @Setter
    private B b;
}

public class B {
    @Getter
    @Setter
    private List<A_8> as;

    public static void main(String[] args) {
    }
}