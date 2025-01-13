#include <QObject>\n#include "FooTableModel.h"\n#include "Widget.h"\n\nclass Controller : public QObject {\n    Q_OBJECT\n\npublic:\n    Controller(QWidget* parent = nullptr) {\n        m_model = new FooTableModel(this);\n        m_widget = new Widget(parent);\n\n        // Set the model for the view\n        m_widget->setModel(m_model);\n    }\n\n    ~Controller() {\n        // No need to manually delete m_model or m_widget as they will be deleted by the QObject hierarchy\n    }\n\nprivate:\n    FooTableModel* m_model;\n    Widget* m_widget;\n};