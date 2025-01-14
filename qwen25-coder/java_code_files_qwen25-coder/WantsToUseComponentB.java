@Component(service = WantsToUseComponentB.class)
public class WantsToUseComponentB {

    private volatile ComponentB componentB;

    @Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY)
    public void setComponentB(ComponentB componentB) {
        this.componentB = componentB;
    }

    public void doSomethingWithComponentB() {
        componentB.doSomething();
    }

    public static void main(String[] args) {
    }
}

@interface Component {
    Class<?> service();
}

@interface Reference {
    ReferenceCardinality cardinality();
}

enum ReferenceCardinality {
    MANDATORY_UNARY
}

interface ComponentB {
    void doSomething();
}