#include <Windows.h>\n\nint main() {\n    SHELLEXECUTEINFO sei = { sizeof(sei) };\n    sei.fMask = SEE_MASK_NOCLOSEPROCESS;\n    sei.lpVerb = "runas";\n    sei.lpFile = "path\\to\\upgrader.exe";\n    sei.lpParameters = NULL;\n    sei.nShow = SW_SHOWNORMAL;\n\n    ShellExecuteEx(&sei);\n\n    return 0;\n}