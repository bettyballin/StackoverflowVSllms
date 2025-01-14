#include <msxml6.h>

int main() {
    IXMLDOMDocumentPtr doc;
    IXMLDOMNodePtr node;

    // Initialize COM
    CoInitialize(NULL);

    // Create an instance of the DOM document
    doc.CreateInstance(__uuidof(DOMDocument60));

    // Load the XML document
    doc->loadXML("<HIVE Name='HKEY_CURRENT_USER'><Key Name='Network'/></HIVE>");

    // Select the node
    node = doc->selectSingleNode(L"/HIVE[@Name='HKEY_CURRENT_USER']/Key[@Name='Network']");

    // Do something with the node...

    // Clean up
    CoUninitialize();

    return 0;
}