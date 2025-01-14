#include <stdio.h>
#include <string.h>
#include <libxml/parser.h>                      // LibXML2 Parser (required)
#include <libxml/validation.h>

// Define the error callback function
void error_generic_func(void *ctx, const char *msg, ...) {
    fprintf(stderr, "%s\n", msg);
}

// Sample method for validating an XML file using provided Schema
int validate_sample() {
    xmlChar *schemaBuffer = NULL;
    int schemaBufferSize;
    xmlDocPtr doc = NULL, schemadoc = NULL;      // Init pointers to documents
    xmlSchemaPtr schema = NULL;                  // Init pointer to compiled XSD Schema
    xmlSchemaParserCtxtPtr ctxt;             // Init parser context
    FILE *schemaFile, *xmlFile;
    int ret;

    LIBXML_TEST_VERSION                       /* Must call before using libxml2 */

    // Parse the provided Schema (XSD file) into a schema
    xmlLineNumbersDefault(1);
    ctxt = xmlSchemaNewParserCtxt("test.xsd");
    schema = xmlSchemaParse(ctxt);
    xmlSchemaFreeParserCtxt(ctxt);
    if (!schema){ 
        fprintf(stderr,"Failed to parse xsd\n");
        return 1; 
    }

    // Open XML file for reading, and load it into a new doc object
    xmlFile=fopen("test.xml", "r");
    doc = xmlParseFile(fileno(xmlFile));
    fclose(xmlFile);
    if (!doc) { 
        fprintf(stderr,"Failed to parse test.xml\n");
        return 1; 
    }

    // Perform the validation, use a callback for errors
    xmlSetGenericErrorFunc(NULL, error_generic_func); /* To receive messages from xml library */
    ret = xmlSchemaValidateDoc(schema, (const xmlDocPtr)doc);
    if (!ret){ 
        fprintf(stderr,"Failed to validate test.xml\n");
    } else{ 
        printf("Validation successful\n");
    }
    xmlFreeDoc((xmlDocPtr) doc);      // Free up memory.
    xmlSchemaFree(schema); // Free the schema
    return 0;
}

int main() {
    return validate_sample();
}