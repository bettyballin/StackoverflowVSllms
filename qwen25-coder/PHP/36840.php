<?php\n// Create a new XMLWriter instance\n$xml = new XMLWriter();\n\n// Open the output file for writing (or use 'php://output' to write directly to output)\n$xml->openURI('example.xml');\n\n// Start the document with version 1.0 and UTF-8 encoding\n$xml->startDocument('1.0', 'UTF-8');\n\n// Start an element named "bookstore"\n$xml->startElement("bookstore");\n\n// Add a child element "book" with attributes\n$xml->startElement("book");\n$xml->writeAttribute("category", "children");\n\n// Add sub-elements to the book\n$xml->writeElement("title", 'Harry Potter');\n$xml->writeElement("author", 'J K. Rowling');\n$xml->writeElement("year", '2005');\n$xml->writeElement("price", '29.99');\n\n// End the "book" element\n$xml->endElement();\n\n// Add another book element\n$xml->startElement("book");\n$xml->writeAttribute("category", "web");\n\n// Add sub-elements to this book\n$xml->writeElement("title", 'Learning XML');\n$xml->writeElement("author", 'Erik T. Ray');\n$xml->writeElement("year", '2003');\n$xml->writeElement("price", '39.95');\n\n// End the "book" element\n$xml->endElement();\n\n// End the "bookstore" element\n$xml->endElement();\n\n// End the document and flush output\n$xml->endDocument();\n?>