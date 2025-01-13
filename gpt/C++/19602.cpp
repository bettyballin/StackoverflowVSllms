#include <QOpenGLWidget>\n#include <QOpenGLFunctions>\n\nclass MyOpenGLWidget : public QOpenGLWidget, protected QOpenGLFunctions\n{\n    Q_OBJECT\n\npublic:\n    MyOpenGLWidget(QWidget *parent = nullptr) : QOpenGLWidget(parent) {}\n\nprotected:\n    void initializeGL() override\n    {\n        initializeOpenGLFunctions();\n        // Initialization code here\n    }\n\n    void paintGL() override\n    {\n        // Rendering code here\n\n        // If you need to manually swap buffers (usually not necessary):\n        // context()->swapBuffers(context()->surface());\n    }\n\n    void resizeGL(int w, int h) override\n    {\n        // Handle window resizing\n    }\n};