#include <mysql/mysql.h>\n#include <iostream>\n\nint main() {\n    // Initialize MySQL connection\n    MYSQL *sqlhnd = mysql_init(NULL);\n    if (!mysql_real_connect(sqlhnd, "server", "user", "pass", "database", port, NULL, 0)) {\n        std::cerr << "Error connecting to MySQL: " << mysql_error(sqlhnd) << std::endl;\n        return 1;\n    }\n\n    // Execute query\n    if (mysql_query(sqlhnd, "SELECT * FROM `my_table`")) {\n        std::cerr << "Error executing query: " << mysql_error(sqlhnd) << std::endl;\n        return 1;\n    }\n\n    // Store result\n    MYSQL_RES *confres = mysql_store_result(sqlhnd);\n    if (!confres) {\n        std::cerr << "Error storing result: " << mysql_error(sqlhnd) << std::endl;\n        return 1;\n    }\n\n    // Get number of rows and fields\n    int totalrows = mysql_num_rows(confres);\n    int numfields = mysql_num_fields(confres);\n\n    // Fetch rows\n    MYSQL_ROW row;\n    while ((row = mysql_fetch_row(confres))) {\n        for (int i = 0; i < numfields; i++) {\n            std::cout << "Field " << i << ": " << row[i] << std::endl;\n        }\n    }\n\n    // Clean up\n    mysql_free_result(confres);\n    mysql_close(sqlhnd);\n\n    return 0;\n}