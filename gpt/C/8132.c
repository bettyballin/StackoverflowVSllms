#include <libxml/parser.h>\n#include <libxml/xpath.h>\n#include <libxml/xpathInternals.h>\n\nint xt_parseXmlResult(xmlDocPtr doc, const char *xpath, assoc_arrayc_t expr, arrayc_t *result)\n{\n    xmlXPathContextPtr xpathCtx = xmlXPathNewContext(doc);\n\n    // Register namespaces ...\n\n    // Evaluate main xpath expression\n    xmlXPathObjectPtr xpathNodes = xmlXPathEvalExpression((xmlChar *)xpath, xpathCtx);\n\n    if(xpathNodes == NULL || xpathNodes->nodesetval == NULL)\n    {\n        xmlXPathFreeContext(xpathCtx);\n        xmlFreeDoc(doc);\n        return -1; // Handle error appropriately\n    }\n\n    int nbDocs = xpathNodes->nodesetval->nodeNr;\n\n    for (int row = 0; row < nbDocs; row++)\n    {\n        xmlNodePtr currentNode = xpathNodes->nodesetval->nodeTab[row];\n        xmlXPathContextPtr subCtx = xmlXPathNewContext(doc);\n        subCtx->node = currentNode;\n\n        // Register namespaces ...\n\n        for (int col = 0; col < expr.nbItems; col++)\n        {\n            xmlXPathObjectPtr xpathRows = xmlXPathEvalExpression((xmlChar *)expr.itemList[col].val, subCtx);\n\n            if(xpathRows != NULL)\n            {\n                result->data[(row + 1) * result->nbCols + col] = strdup((char *)xmlXPathCastToString(xpathRows)); \n                xmlXPathFreeObject(xpathRows);\n            }\n\n        }\n        xmlXPathFreeContext(subCtx);\n    }\n\n    xmlXPathFreeObject(xpathNodes);\n    xmlXPathFreeContext(xpathCtx);\n    xmlFreeDoc(doc); \n    return 0;\n}