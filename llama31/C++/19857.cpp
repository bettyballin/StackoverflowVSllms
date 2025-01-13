#include <algorithm>\n#include <list>\n#include <iostream>\n#include <iterator>\n\nint main() {\n    std::list<int> a = {1};\n    std::list<std::list<int>> a_list = {a};\n\n    std::ostream_iterator<int> int_output(std::cout, "\n");\n\n    std::for_each(a_list.begin(), a_list.end(),\n        [&int_output](const std::list<int>& inner_list) {\n            std::copy(inner_list.begin(), inner_list.end(), int_output);\n        });\n\n    return 0;\n}