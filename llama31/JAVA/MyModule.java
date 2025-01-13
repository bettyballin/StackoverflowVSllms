import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class MyModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ComponentB.class).to(ComponentBImpl.class);
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MyModule());
    }
}

class ComponentB {}

class ComponentBImpl extends ComponentB {}