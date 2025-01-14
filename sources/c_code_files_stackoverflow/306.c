#include <stdio.h>

int main()
{
   char *pageTitle = "Look, a JPEG!";
   char *urlImage  = "/myimage.jpeg";

   // Send HTTP header.
   printf("Content-type: text/html\r\n\r\n");

   // Send the generated HTML.
   printf("<html><head><title>%s</title></head>\r\n"
          "<body>\r\n"
          "<h1>%s</h1>\r\n"
          "<img src=\"%s\">\r\n"
          "</body></html>\r\n",
          pageTitle, pageTitle, urlImage);

   return 0;
}