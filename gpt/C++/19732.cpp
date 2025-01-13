#include <QVariant>\n#include <QString>\n\nclass MyClass {\npublic:\n    QVariant myProperty;\n\n    void setMyProperty(const QVariant &value) {\n        myProperty = value;\n    }\n    \n    QVariant getMyProperty() const {\n        return myProperty;\n    }\n};\n\n// Usage\nMyClass obj;\nobj.setMyProperty(QString("Hello")); // set a QString\nobj.setMyProperty(QVariant(QVariant::String)); // set a null value