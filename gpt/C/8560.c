#include <stdio.h>\n#include <stdlib.h>\n\nint main() {\n    if (remove("/var/tmp/my file.pdf") != 0)\n        perror("Error deleting file");\n    else\n        printf("File successfully deleted\n");\n\n    return 0;\n}