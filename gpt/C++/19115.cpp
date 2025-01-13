#include <sqlite3.h>\n#include <iostream>\n\nint main() {\n    sqlite3* db;\n    char* errMsg = 0;\n\n    int rc = sqlite3_open("music.db", &db);\n    if (rc) {\n        std::cerr << "Can't open database: " << sqlite3_errmsg(db) << std::endl;\n        return rc;\n    }\n\n    const char* sql = "CREATE TABLE IF NOT EXISTS mp3_files (id INTEGER PRIMARY KEY, filename TEXT, tags TEXT)";\n    rc = sqlite3_exec(db, sql, 0, 0, &errMsg);\n    if (rc != SQLITE_OK) {\n        std::cerr << "SQL error: " << errMsg << std::endl;\n        sqlite3_free(errMsg);\n    }\n\n    sqlite3_close(db);\n    return 0;\n}