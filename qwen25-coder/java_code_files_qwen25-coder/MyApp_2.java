import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MyApp_2 extends ApplicationAdapter {
    OrthographicCamera camera;

    @Override
    public void create() {
        // Initialization code here
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Render code here
        camera.update();
    }

    public static void main(String[] args) {
        // Code to launch the application
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "My Application";
        config.width = 800;
        config.height = 480;
        new LwjglApplication(new MyApp_2(), config);
    }
}