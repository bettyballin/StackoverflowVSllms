// Example using Crow library\n#include "crow.h"\n\nint main() {\n    crow::SimpleApp app;\n\n    CROW_ROUTE(app, "/process")\n    ([](const crow::request& req) {\n        auto data = req.body;\n        // Process the data\n        return crow::response(200, "Data processed");\n    });\n\n    app.port(18080).multithreaded().run();\n}