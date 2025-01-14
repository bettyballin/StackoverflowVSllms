pp
#include <QGLContext>
#include <QApplication>

int main(int argc, char** argv) {
    QApplication app(argc, argv);
    QGLContext context;
    context.create();
    context.makeCurrent();
    context.swapBuffers();
    return 0;
}