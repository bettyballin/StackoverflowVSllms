#include <soci.h>\n#include <soci-mssql.h>\n\nint main() {\n    // Example connection string\n    std::string connectionString = "db=your_database user=your_username password=your_password";\n\n    try {\n        // Create a session\n        soci::session sql(soci::mssql, connectionString);\n\n        // Execute a query\n        soci::rowset<soci::row> rs = (sql.prepare << "SELECT * FROM your_table");\n\n        // Loop through results\n        for (soci::rowset<soci::row>::iterator i = rs.begin(); i != rs.end(); ++i) {\n            std::cout << "Your column name: " << (*i)["column_name"] << std::endl;\n        }\n    } catch (soci::sql_exception const& e) {\n        std::cerr << "SQL error: " << e.what() << std::endl;\n    }\n\n    return 0;\n}