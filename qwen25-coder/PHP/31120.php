$reader = new XMLReader();\n$reader->open('example.xml');\n\nwhile ($reader->read()) {\n    if ($reader->nodeType == XMLREADER::ELEMENT && $reader->localName == 'item') {\n        echo "Node Name: " . $reader->name;\n        echo "\n";\n        echo "Node Value: " . $reader->readString();\n        echo "\n\n";\n    }\n}\n\n$reader->close();