#include <boost/algorithm/string.hpp>\n#include <string>\n\nstd::string xparam = "  HELLO  ";\n\n// Trim and convert to lower case\nboost::trim(xparam);\nboost::to_lower(xparam);\n\n// Now xparam is "hello"