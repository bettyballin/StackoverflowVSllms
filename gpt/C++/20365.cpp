#include <boost/regex.hpp>\n#include <iostream>\n#include <string>\n\nint main() {\n    std::string html = R"(\n        <div class="tab news selected">\n            <a href="link1.html">Link 1</a>\n            <a href="link2.html">Link 2</a>\n        </div>\n    )";\n\n    std::string pattern = R"(<div\s+class="tab news selected".*?>.*?<a\s+href=.*?>.*?</a>.*?</div>)";\n    boost::regex expr(pattern, boost::regex::perl | boost::regex::icase);\n    boost::smatch match;\n\n    if (boost::regex_search(html, match, expr)) {\n        std::cout << "Match found: " << match[0] << std::endl;\n    } else {\n        std::cout << "No match found." << std::endl;\n    }\n\n    return 0;\n}