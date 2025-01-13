#include <QDebug>\n#include <QCoreApplication>\n#include <QNetworkAccessManager>\n#include <QNetworkRequest>\n#include <QNetworkReply>\n#include <QTextCodec>\n\nclass NetworkAccess: public QObject {\n    Q_OBJECT\n\npublic:\n    NetworkAccess(QUrl url) {\n        manager = new QNetworkAccessManager(this);\n\n        QNetworkRequest request;\n        request.setUrl(url);\n        request.setRawHeader("User-Agent", "Mozilla/5.0 (X11; U; Linux i686 (x86_64); en-US; rv:1.9.0.1) Gecko/2008070206 Firefox/3.0.1");\n        request.setRawHeader("Accept-Charset", "UTF-8");\n\n        connect(manager, SIGNAL(finished(QNetworkReply*)), this, SLOT(replyFinished(QNetworkReply*)));\n        manager->get(request);\n    }\n\nprivate slots:\n    void replyFinished (QNetworkReply *reply) {\n        if(reply->error()) {\n            qDebug() << "Error:" << reply->errorString();\n        } else {\n            QByteArray data = reply->readAll();\n            QString html;\n            \n            // Detect charset from meta tags in HTML if available\n            // If not, defaults to UTF-8\n            QTextCodec *codec = QTextCodec::codecForName(reply->header(QNetworkRequest::ContentTypeHeader).toString().toLatin1());\n            if (!codec) codec = QTextCodec::codecForUtfText(data);\n            html = codec->toUnicode(data);\n\n            qDebug() << "HTML:" << html;\n        }\n\n        reply->deleteLater();\n    }\n\nprivate:\n    QNetworkAccessManager *manager;\n};\n\n#include "main.moc"\n\nint main(int argc, char **argv)\n{\n    QCoreApplication app(argc, argv);\n\n    NetworkAccess network(QUrl("http://ru.wiktionary.org/wiki/bovo"));\n\n    return app.exec();\n}