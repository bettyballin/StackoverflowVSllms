#include "gumbo.h"\n\nint main() {\n    const char* html = "<html><body>Hello, World!</body></html>";\n    GumboOutput* output = gumbo_parse(html);\n\n    // Do something with the parsed HTML...\n\n    gumbo_destroy_output(&kGumboDefaultOptions, output);\n    return 0;\n}