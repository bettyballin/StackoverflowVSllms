import java.util.Map;

public class PluginManagerFramework {

    public interface Module {
        void start();
        void stop();
    }

    public interface ModuleManager {
        void loadModule(String path);
        void unloadModule(String moduleName);
        Map<String, Module> listModules();
    }

    public interface EventListener<T> {
        void onEvent(T event);
    }

    public static void main(String[] args) {
    }

}