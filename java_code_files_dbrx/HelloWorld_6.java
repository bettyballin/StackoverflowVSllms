import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class HelloWorld_6 {
    public static void main(String[] args) {
        // Initialize GLFW and set up any required state (for the window, for example)
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        // glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE); // Uncomment this line on macOS

        long window = glfwCreateWindow(800, 600, "Hello World!", NULL, NULL);
        if (window == NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        }
        glfwMakeContextCurrent(window);
        glfwShowWindow(window);

        // Initialize OpenGL capabilities
        GL.createCapabilities();
        System.out.println(glGetString(GL_VERSION));

        // Game/rendering loop
        while (!glfwWindowShouldClose(window)) {
            // Render here (you can use OpenGL functions, for example)
            renderLoop(window);

            glfwSwapBuffers(window);
            glfwPollEvents();
        }

        // Terminate GLFW and free the window resources
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);
        glfwTerminate();
    }

    private static void renderLoop(long window) {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // Clear the framebuffer
        // Additional rendering code can be added here
    }
}