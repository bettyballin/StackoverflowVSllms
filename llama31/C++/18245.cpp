#include <functional>\n\ntemplate <typename Func>\nvoid superFor(int iterations, Func func) {\n    for (int i = 0; i < iterations; ++i) {\n        func();\n    }\n}