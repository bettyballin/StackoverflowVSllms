$reader = new XMLReader();\nif ($reader->open("xml.xml")) {\n    while ($reader->read()) {\n        if ($reader->nodeType == XMLReader::ELEMENT && $reader->localName == "tag") {\n            // Process your element here\n        }\n        if ($reader->nodeType == XMLReader::ELEMENT && $reader->localName == "child") {\n            // Process child element here\n        }\n    }\n    $reader->close();\n}