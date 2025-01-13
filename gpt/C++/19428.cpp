#include <odbc++/connection.h>\n#include <odbc++/statement.h>\n#include <odbc++/resultset.h>\n\nint main() {\n    try {\n        // Establish the connection\n        odbc::Connection* con = odbc::DriverManager::getConnection("DSN=mydsn;UID=user;PWD=password");\n        \n        // Create a statement\n        odbc::Statement* stmt = con->createStatement();\n\n        // Set the query timeout to 300 seconds\n        stmt->setQueryTimeout(300);\n\n        // Execute the stored procedure\n        odbc::ResultSet* rs = stmt->executeQuery("{call my_stored_procedure()}");\n\n        // Process the result set\n        while (rs->next()) {\n            // Process each row\n        }\n\n        // Clean up\n        delete rs;\n        delete stmt;\n        delete con;\n    } catch (odbc::SQLException& e) {\n        std::cerr << "Error: " << e.getMessage() << std::endl;\n    }\n\n    return 0;\n}