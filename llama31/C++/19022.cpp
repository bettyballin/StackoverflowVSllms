#include <boost/algorithm/string/join.hpp>\n#include <vector>\n\nstd::vector<std::string> columns = {"column1", "column2", "column3"};\nstd::string selectSql = "SELECT ";\nselectSql += boost::algorithm::join(columns, ", ");\nselectSql += " FROM some-table";