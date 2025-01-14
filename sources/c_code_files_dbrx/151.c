#include <stdio.h>
#include <libxml/parser.h>
#include <libxml/tree.h>

int main() {
    xmlDocPtr doc;  /* A pointer to an xmlDoc structure (document) */
    xmlNodePtr root_node, node, node1, node2;   /* A generic pointer to a tree node of any type (including the Doc nodes, Element nodes, etc.) For more info about: tree nodes check "tree.h" file.*/
                            /* A pointer to a Node in the XML Tree */
    doc = xmlNewDoc((xmlChar *) "1.0");   /* Create a new Document */;
    root_node  = xmlNewNode(NULL, (const xmlChar*)"root"); /* The root node is a child of this documents tree */
    xmlDocSetRootElement(doc, root_node);       /* Set the children-nodes for our root. In this case there are no children!*/
    xmlSaveFormatFileEnc("-","UTF-8", doc, "  ", 1);   /* The second argument is the encoding format of the output file (default is UTF-8). Encoding may be NULL to autodetected */; // Save in memory buffer for testing purposes. Change "-" with the target filename when ready
    xmlFreeDoc(doc);        /* Free all the memory allocated by this Document, except memory reserved by subdescriptors (nodes, entities and DTDs) */
    return 0;
}