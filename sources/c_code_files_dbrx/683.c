#include <GLFW/glfw3.h>
#include <GL/gl.h>
#include <math.h>

void renderLoop(GLFWwindow* window) {
    // Clear previous frame data
    glClearColor(0f, 0f, 0f, 1.0f);
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    // Render your rectangle with color changes for flickering effect
    double currentTime = glfwGetTime();
    float frequency = (float) sin(currentTime * 2 * M_PI);
    if(frequency > 0) {
        // Change to desired color A on positive frequencies
        glColor3f(1.0f, 0.5f, 0f);
    } else {
        // Change to desired color B on negative frequencies
        glColor3f(0f, 1.0f, 0.682f);
    }

    glBegin(GL_QUADS);
        glVertex2i(-275,-275); //x, y position of your square on screen
        glVertex2i(275,-275);
        glVertex2i(275, 275);
        glVertex2i(-275, 275);
    glEnd();
}