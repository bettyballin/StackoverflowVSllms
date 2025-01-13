import java.lang.String;

public class AppModule implements EntryPoint {
    private final Router router;

    public AppModule() {
        router = new Router();
        router.addRoute("home", new HomePresenter());
        router.addRoute("admin", new AdminPresenter());
    }

    @Override
    public void onModuleLoad() {
        router.route(RootPanel.get().getUrl());
    }

    public static void main(String[] args) {
        // To make this code executable with javac, we need to create an instance of AppModule
        AppModule appModule = new AppModule();
        // However, EntryPoint is an interface from GWT (Google Web Toolkit), 
        // which is not a standard Java library. Therefore, we can't directly run this code with javac.
        // We can only compile it, and then it needs to be run in a GWT environment.
    }
}