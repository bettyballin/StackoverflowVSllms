#include <vector>\n#include <string>\n#include <algorithm>\n\nstruct Column {\n    std::string _name;\n};\n\nint main() {\n    std::vector<Column> columns = {{"column1"}, {"column2"}, {"column3"}};\n    \n    std::string selectSql = "SELECT ";\n    if (!columns.empty()) {\n        selectSql += std::accumulate(columns.begin(), columns.end(),\n                                     std::string(),\n                                     [](const std::string& a, const Column& b) -> std::string {\n                                         return a + (a.empty() ? "" : ", ") + b._name;\n                                     });\n    }\n    selectSql += " FROM some-table";\n    \n    // Output the SQL query\n    std::cout << selectSql << std::endl;\n\n    return 0;\n}