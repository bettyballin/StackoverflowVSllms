#include <libxml/parser.h>
#include <libxml/xpath.h>
#include <libxml/xpathInternals.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Define the missing types
typedef struct {
    int nbItems;
    struct {
        char *val;
    } itemList[];
} assoc_arrayc_t;

typedef struct {
    int nbCols;
    char **data;
} arrayc_t;

int xt_parseXmlResult(xmlDocPtr doc, const char *xpath, assoc_arrayc_t expr, arrayc_t *result)
{
    xmlXPathContextPtr xpathCtx = xmlXPathNewContext(doc);

    // Register namespaces ...

    // Evaluate main xpath expression
    xmlXPathObjectPtr xpathNodes = xmlXPathEvalExpression((xmlChar *)xpath, xpathCtx);

    if(xpathNodes == NULL || xpathNodes->nodesetval == NULL)
    {
        xmlXPathFreeContext(xpathCtx);
        xmlFreeDoc(doc);
        return -1; // Handle error appropriately
    }

    int nbDocs = xpathNodes->nodesetval->nodeNr;

    for (int row = 0; row < nbDocs; row++)
    {
        xmlNodePtr currentNode = xpathNodes->nodesetval->nodeTab[row];
        xmlXPathContextPtr subCtx = xmlXPathNewContext(doc);
        subCtx->node = currentNode;

        // Register namespaces ...

        for (int col = 0; col < expr.nbItems; col++)
        {
            xmlXPathObjectPtr xpathRows = xmlXPathEvalExpression((xmlChar *)expr.itemList[col].val, subCtx);

            if(xpathRows != NULL)
            {
                result->data[(row + 1) * result->nbCols + col] = strdup((char *)xmlXPathCastToString(xpathRows)); 
                xmlXPathFreeObject(xpathRows);
            }

        }
        xmlXPathFreeContext(subCtx);
    }

    xmlXPathFreeObject(xpathNodes);
    xmlXPathFreeContext(xpathCtx);
    xmlFreeDoc(doc); 
    return 0;
}

int main() {
    // Example usage
    xmlDocPtr doc = xmlParseFile("example.xml");
    assoc_arrayc_t expr = {2, {{(char *)"xpath/expr1"}, {(char *)"xpath/expr2"}}};
    arrayc_t result = {2, NULL};
    result.data = malloc(expr.nbItems * sizeof(char *));
    int ret = xt_parseXmlResult(doc, "/xpath/expr", expr, &result);
    if (ret == 0) {
        for (int i = 0; i < expr.nbItems; i++) {
            printf("%s\n", result.data[i]);
            free(result.data[i]);
        }
        free(result.data);
    }
    return ret;
}