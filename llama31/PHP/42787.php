$xml = '<root><name>John</name></root>';\n$dtdFile = 'path/to/your/dtd.dtd';\n\n$dom = new DOMDocument();\n$dom->loadXML($xml);\nif (!$dom->validate()) {\n    echo "XML is not well-formed.";\n} else {\n    $dom->loadDTD($dtdFile);\n    if ($dom->validate()) {\n        echo "XML is valid.";\n    } else {\n        echo "XML is not valid.";\n    }\n}