#include <QObject>\n\n   class FROGGER_DLLSPEC MyObject : public QObject {\n       Q_OBJECT\n   public:\n       MyObject(QObject *parent = nullptr);\n       // Your other members here...\n   signals:\n       void someSignal();\n\n   public slots:\n       void someSlot();\n   };