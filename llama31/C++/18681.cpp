#include <windows.h>\n\nint main() {\n    TIME_ZONE_INFORMATION tzi;\n    GetTimeZoneInformation(&tzi);\n    WCHAR tzId[256];\n    StringCchPrintf(tzId, 256, L"%s", tzi.TimeZoneKeyName);\n    // Store tzId in your database\n    return 0;\n}