#include <stdio.h>\n#include <string.h>\n\nint main() {\n    // Set the input HTML file and output PDF file\n    char *inputFile = "input.html";\n    char *outputFile = "output.pdf";\n\n    // Create the command to execute wkhtmltopdf\n    char command[1024];\n    sprintf(command, "wkhtmltopdf.exe %s %s", inputFile, outputFile);\n\n    // Execute the command\n    system(command);\n\n    return 0;\n}