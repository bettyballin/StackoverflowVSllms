#include <QApplication>\n#include "Controller.h"\n\nint main(int argc, char* argv[]) {\n    QApplication app(argc, argv);\n\n    Controller controller;\n    controller.show(); // Assuming you have a show method in the Controller that shows the widget\n\n    return app.exec();\n}