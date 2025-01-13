#include <string>\n#include <codecvt>\n\nint main() {\n    std::string utf8 = "Hello, ";\n\n    // Convert to UTF-16\n    std::wstring_convert<std::codecvt_utf8_utf16<wchar_t>, wchar_t> converter;\n    std::wstring utf16 = converter.from_bytes(utf8);\n\n    // Convert to UTF-32\n    std::wstring_convert<std::codecvt_utf8<wchar_t>, wchar_t> converter32;\n    std::u32string utf32 = converter32.from_bytes(utf8);\n\n    return 0;\n}