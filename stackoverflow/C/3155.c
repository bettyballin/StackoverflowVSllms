#include <stdio.h>\n\nmain()\n{\n   char *pageTitle = "Look, a JPEG!";\n   char *urlImage  = "/myimage.jpeg";\n\n// Send HTTP header.\n   printf("Content-type: text/html\r\n\r\n");\n\n// Send the generated HTML.\n   printf("<html><head><title>%s</title></head>\r\n"\n          "<body>\r\n"\n          "<h1>%s</h1>\r\n"\n          "<img src=\"%s\">\r\n"\n          "</body></html>\r\n",\n          pageTitle, pageTitle, urlImage);\n}