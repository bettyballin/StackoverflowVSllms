pp
#include <QSqlDatabase>
#include <QSqlQuery>
#include <QVariant>

int main() {
    // Connect to database
    QSqlDatabase db = QSqlDatabase::addDatabase("QMYSQL");
    db.setHostName("your_host");
    db.setDatabaseName("your_database");
    db.setUserName("your_username");
    db.setPassword("your_password");
    if (!db.open()) {
        // Handle error
        return 1;
    }

    // Prepare SQL query
    QSqlQuery query;
    query.prepare("SELECT * FROM your_table WHERE id = :id");

    // Add bind value
    int id = 123;
    query.bindValue(":id", id);

    // Execute query
    if (!query.exec()) {
        // Handle error
        return 1;
    }

    // Fetch results
    while (query.next()) {
        // Handle results
    }

    return 0;
}