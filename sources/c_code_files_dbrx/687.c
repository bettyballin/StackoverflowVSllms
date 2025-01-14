#include <libxml/parser.h>
#include <libxml/tree.h>

int main() {
    xmlDocPtr doc; // document pointer
    xmlNodePtr root; // root node pointer

    doc = xmlNewDoc(BAD_CAST "1.0"); 
    // create a new XML tree
    root = xmlNewNode(NULL, BAD_CAST "root");

    // add the root node to the document
    xmlDocSetRootElement(doc, root);

    // free the document when we're done with it
    xmlFreeDoc(doc);

    return 0;
}