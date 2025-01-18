public class myClassName {

    private MyInterface myImplementation;

    public myClassName(MyInterface implementation){
        this.myImplementation = implementation;
    }

    void myMethod() {
        AnotherThirdPartyClass param = new AnotherThirdPartyClass("abc");
        // ...
        this.myImplementation.execute(param); // Now, MyImplementation is used instead of ThirdParityClass directly. It can be easily mocked for testing purposes.
    }
}

interface MyInterface {
    void execute(AnotherThirdPartyClass param);
}

class AnotherThirdPartyClass {
    public AnotherThirdPartyClass(String s) {
        // ...
    }
}