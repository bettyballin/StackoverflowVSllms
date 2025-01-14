#include <libxml/parser.h>
#include <libxml/xpath.h>
#include <stdio.h>

int main() {
    xmlDocPtr doc = xmlParseFile("yourfile.xml");
    xmlXPathContextPtr context = xmlXPathNewContext(doc);
    xmlXPathObjectPtr result = xmlXPathEvalExpression((xmlChar *)"//yourXpathExpression", context);

    xmlNodeSetPtr nodeset = result->nodesetval;
    for (int i = 0; i < nodeset->nodeNr; i++) {
        xmlNodePtr node = nodeset->nodeTab[i];
        xmlChar* content = xmlNodeGetContent(node);
        printf("%s\n", content);
        xmlFree(content);
    }

    xmlXPathFreeObject(result);
    xmlXPathFreeContext(context);
    xmlFreeDoc(doc);

    return 0;
}