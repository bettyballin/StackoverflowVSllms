#include <Windows.h>\n\nint main() {\n    LANGID langId = GetUserDefaultUILanguage();\n    return 0;\n}