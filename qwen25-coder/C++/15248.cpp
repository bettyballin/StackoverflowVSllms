#include <iostream>\n#include <boost/chrono.hpp>\n\nint main() {\n    auto start_time = boost::chrono::steady_clock::now();\n\n    while (true) {\n        // Your loop code here\n        Blah();\n\n        auto current_time = boost::chrono::steady_clock::now();\n        if ((current_time - start_time) >= boost::chrono::milliseconds(30)) {\n            break;\n        }\n    }\n\n    return 0;\n}