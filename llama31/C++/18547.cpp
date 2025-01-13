#include <Windows.h>\n\nint main() {\n    // Mark a file as a system file\n    SetFileAttributesA("C:\\path\\to\\file.txt", FILE_ATTRIBUTE_SYSTEM);\n\n    // Unmark a file as a system file\n    SetFileAttributesA("C:\\path\\to\\file.txt", 0);\n\n    // Mark a folder as a system folder\n    SetFileAttributesA("C:\\path\\to\\folder", FILE_ATTRIBUTE_SYSTEM);\n\n    // Unmark a folder as a system folder\n    SetFileAttributesA("C:\\path\\to\\folder", 0);\n\n    return 0;\n}