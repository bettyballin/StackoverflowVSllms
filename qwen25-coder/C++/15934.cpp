#include <QApplication>\n#include <QPushButton>\n\nint main(int argc, char *argv[]) {\n    QApplication app(argc, argv);\n\n    QPushButton hello("Hello world!");\n    QObject::connect(&hello, &QPushButton::clicked, &app, &QCoreApplication::quit);\n    hello.show();\n\n    return app.exec();\n}