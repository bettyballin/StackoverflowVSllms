<?php\n\n$xmlString = <<<XML\n<!DOCTYPE note SYSTEM "custom.dtd">\n<note>\n    <to>Tove</to>\n    <from>Jani</from>\n    <heading>Reminder</heading>\n    <body>Don't forget me this weekend!</body>\n</note>\nXML;\n\n$dtdContent = <<<DTD\n<!ELEMENT note (to,from,heading,body)>\n<!ELEMENT to (#PCDATA)>\n<!ELEMENT from (#PCDATA)>\n<!ELEMENT heading (#PCDATA)>\n<!ELEMENT body (#PCDATA)>\nDTD;\n\nfile_put_contents('custom.dtd', $dtdContent); // Save the DTD content to a file\n\n$dom = new DOMDocument;\n$internalErrors = libxml_use_internal_errors(true);\n\nif ($dom->loadXML($xmlString)) {\n    if (!$dom->validate()) {\n        echo "Invalid XML\n";\n    } else {\n        echo "Valid XML\n";\n    }\n} else {\n    echo "Error loading XML\n";\n}\n\nlibxml_clear_errors();\nlibxml_use_internal_errors($internalErrors);\n\n?>