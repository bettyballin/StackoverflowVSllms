#include <QObject>
#include <QNetworkAccessManager>
#include <QNetworkRequest>
#include <QNetworkReply>
#include <QUrl>
#include <QByteArray>
#include <QString>

class MyClass : public QObject
{
    Q_OBJECT

public:
    MyClass();
    void fetch(); 

public slots:
    void replyFinished(QNetworkReply*);

private:
    QNetworkAccessManager* m_manager;
};

MyClass::MyClass()
{
    m_manager = new QNetworkAccessManager(this);

    connect(m_manager, SIGNAL(finished(QNetworkReply*)),
         this, SLOT(replyFinished(QNetworkReply*)));

}

void MyClass::fetch()
{
    m_manager->get(QNetworkRequest(QUrl("http://stackoverflow.com")));
}

void MyClass::replyFinished(QNetworkReply* pReply)
{

    QByteArray data=pReply->readAll();
    QString str(data);

    //process str any way you like!

}

int main()
{
    // Create an instance of MyClass
    MyClass obj;

    // Call the fetch method
    obj.fetch();

    return 0;
}