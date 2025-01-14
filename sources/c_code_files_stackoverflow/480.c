#include <GL/gl.h>
#include <GL/glu.h>
#include <GL/glut.h>

int main(int argc, char** argv) {
    // Initialize GLUT
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
    glutInitWindowSize(250, 250);
    glutInitWindowPosition(100, 100);
    glutCreateWindow("OpenGL Setup Test");

    // Your original line of code here
    glPushAttrib(GL_ALL_ATTRIB_BITS);

    // You would typically enter the GLUT main loop here
    glutMainLoop();

    return 0;
}