import java.lang.String;
public class Foo_4 implements IFoo {
    private IBar bar;

    public void initBarForTesting(IBar newBar) {
        this.bar = newBar;
    }

	public static void main(String[] args) {
	}
}

interface IFoo {
}

interface IBar {
}