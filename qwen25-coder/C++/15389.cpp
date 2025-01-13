#include <Qt>\n#include <QApplication>\n#include <QTcpServer>\n#include <QMessageBox>\n#include <QTcpSocket>\n#include <QtNetwork>\n\n#include "qtserver.h"\n\nServer::Server()\n{\n   tcp = new QTcpServer(this);\n   if (!tcp->listen(QHostAddress::Any,9876)) {\n       printf("ERROR starting server\n");\n       return;\n   }\n   QObject::connect(tcp,SIGNAL(newConnection()),this,SLOT(printline()));\n}\n\nvoid Server::printline()\n{\n   QTcpSocket *client = tcp->nextPendingConnection();\n    if (!client) {\n        return; // No client\n    }\n\n    QObject::connect(client, &QTcpSocket::disconnected,\n                     client, &QTcpSocket::deleteLater);\n\n    // Read all available data from the socket\n    QByteArray data = client->readAll();\n\n    // Trim any trailing null characters and print the string\n    printf("String = %s\n", data.trimmed().data());\n\n    // Close the connection\n    client->close();\n}\n\nint main(int argc,char** argv)\n{\n    QApplication a(argc,argv);\n\n    Server* server = new Server();\n\n    return a.exec();\n}