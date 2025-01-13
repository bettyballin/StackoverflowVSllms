#include <algorithm>\n#include <vector>\n#include <string>\n\nclass A {\npublic:\n    A(std::string a) : _a(a) {}\n\n    bool operator==(const A& p) const {\n        return p._a == _a;\n    }\n\nprivate:\n    std::string _a;\n};\n\nint main() {\n    std::vector<A*> va;\n\n    va.push_back(new A("one"));\n    va.push_back(new A("two"));\n    va.push_back(new A("three"));\n\n    A target("two");\n    auto it = std::find_if(va.begin(), va.end(),\n        [&target](A* p) { return *p == target; });\n\n    if (it != va.end()) {\n        // Found the element\n    }\n\n    // Clean up dynamically allocated memory\n    for (auto p : va) {\n        delete p;\n    }\n\n    return 0;\n}