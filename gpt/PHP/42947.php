$reader = new XMLReader();\n   $reader->open('file.xml');\n   while ($reader->read()) {\n       if ($reader->nodeType == XMLReader::ELEMENT && $reader->name == 'tag') {\n           echo $reader->getAttribute('attribute');\n       }\n   }\n   $reader->close();