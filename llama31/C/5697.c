#include <fcgi_stdio.h>\n\nint main() {\n    while (FCGI_Accept() >= 0) {\n        // your CGI code here\n    }\n    return 0;\n}