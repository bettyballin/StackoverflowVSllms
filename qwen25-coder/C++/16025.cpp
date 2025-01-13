#include <iostream>\n#include <string>\n#include <boost/regex.hpp>\n#include <cstdlib> // for std::stoi\n\nint main() {\n    std::string input = "Hello, here's a test colon&#58;. Here's a test semi-colon&#59;";\n    \n    boost::regex entity_pattern("&#(\\d+);");\n    std::string result = boost::regex_replace(input, entity_pattern,\n        [&](const boost::smatch& match) -> std::string {\n            try {\n                int ascii_code = std::stoi(match[1].str());\n                if (ascii_code >= 32 && ascii_code <= 126) { // Printable ASCII range\n                    return std::string(1, static_cast<char>(ascii_code));\n                }\n            } catch (std::invalid_argument&) {\n                // Handle invalid number format if needed\n            }\n            return match[0].str(); // Return original string on error\n        },\n        boost::format_sed);\n\n    std::cout << result << std::endl;\n    return 0;\n}