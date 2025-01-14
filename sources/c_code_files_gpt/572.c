#include <GL/glut.h>
#include <string.h>

void renderBitmapString(float x, float y, void* font, const char* string) {
    const char* c;
    glRasterPos2f(x, y);
    for (c = string; *c != '\0'; c++) {
        glutBitmapCharacter(font, *c);
    }
}

void display() {
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(1.0, 1.0, 1.0); // Set text color to white
    renderBitmapString(0.0f, 0.0f, GLUT_BITMAP_TIMES_ROMAN_24, "Hello, World!");
    glFlush();
}

int main(int argc, char** argv) {
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
    glutInitWindowSize(800, 600);
    glutInitWindowPosition(100, 100);
    glutCreateWindow("OpenGL Text Rendering Example");
    glutDisplayFunc(display);
    glutMainLoop();
    return 0;
}