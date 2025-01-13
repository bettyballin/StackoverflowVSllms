#include <assert.h>\n\n#define STATIC_ASSERT(expr, msg) \\n    extern char STATIC_ASSERTION_##msg[1]; \\n    extern char STATIC_ASSERTION_##msg[(expr) ? 1 : -1]\n\nint main() {\n    STATIC_ASSERT(sizeof(int) == 4, "sizeof_int_is_not_4");\n    return 0;\n}