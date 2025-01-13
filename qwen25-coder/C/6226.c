#include <stdio.h>\n#include "ini.h"\n\n// Handler function to parse key-value pairs\nint handler(void* user, const char* section, const char* name,\n                    const char* value)\n{\n    printf("section=[%s], name=[%s], value=[%s]\n", section, name, value);\n    return 1;\n}\n\nint main(int argc, char** argv) {\n    if (argc < 2) {\n        printf("Usage: %s <config-file>\n", argv[0]);\n        return 1;\n    }\n    // Parse the INI file\n    if (ini_parse(argv[1], handler, NULL) < 0) {\n        printf("Can't load '%s'\n", argv[1]);\n        return 1;\n    }\n\n    printf("Config loaded.\n");\n    return 0;\n}