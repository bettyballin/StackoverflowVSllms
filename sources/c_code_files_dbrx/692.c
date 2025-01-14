#include <stdio.h>
#include <expat.h>

// declare start and end element callback functions
void startElement(void *data, const char *name, const char **atts);
void endElement(void *data, const char *name);

int main() {
    XML_Parser parser = XML_ParserCreate(NULL);
    if (parser == NULL) {
        fprintf(stderr, "Could not allocate memory for parser\n");
        return 1;
    }
    // set start and end element callback functions
    XML_SetElementHandler(parser, startElement, endElement);

    // Define the callback functions
    void startElement(void *data, const char *name, const char **atts) {
        printf("Start element: %s\n", name);
    }

    void endElement(void *data, const char *name) {
        printf("End element: %s\n", name);
    }

    // parse the XML file
    FILE *fp = fopen("example.xml", "r");
    if (fp == NULL) {
        fprintf(stderr, "Could not open file\n");
        return 1;
    }

    char buffer[1024];
    while (fread(buffer, 1, 1024, fp) > 0) {
        if (XML_Parse(parser, buffer, 1024, 0) == XML_STATUS_ERROR) {
            fprintf(stderr, "Parse error at line %lu:\n%s\n",
                    XML_GetCurrentLineNumber(parser),
                    XML_ErrorString(XML_GetErrorCode(parser)));
            return 1;
        }
    }

    XML_Parse(parser, buffer, 0, 1);

    fclose(fp);
    XML_ParserFree(parser);

    return 0;
}