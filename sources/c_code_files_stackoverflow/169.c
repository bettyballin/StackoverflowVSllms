#include <libxml/parser.h>
#include <libxml/tree.h>
#include <libxml/xmlstring.h>
#include <stdio.h>

int
main(void)
{

  xmlNodePtr root, node;
  xmlDocPtr doc;
  xmlChar *xmlbuff;
  int buffersize;

  /* Create the document. */
  doc = xmlNewDoc(BAD_CAST "1.0");
  root = xmlNewNode(NULL, BAD_CAST "root");

  /* Create some nodes */
  node = xmlNewChild(root, NULL, BAD_CAST "node", NULL);
  node = xmlNewChild(node, NULL, BAD_CAST "inside", NULL);
  node = xmlNewChild(root, NULL, BAD_CAST "othernode", NULL);

  /* Put content in a node: note there are special characters so 
     encoding is necessary! */
  xmlNodeSetContent(node, 
                xmlEncodeSpecialChars(doc, BAD_CAST "text con&tent and <tag>"));

  xmlDocSetRootElement(doc, root);

  /* Dump the document to a buffer and print it for demonstration purposes. */
  xmlDocDumpFormatMemory(doc, &xmlbuff, &buffersize, 1);
  printf((char *) xmlbuff);

  /* Free the allocated memory. */
  xmlFree(xmlbuff);
  xmlFreeDoc(doc);

  return 0;
}