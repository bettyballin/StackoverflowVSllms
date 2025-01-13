<?php\n$xmlString = '\n<node>\n  This is\n  <child>\n    blah\n  </child>\n  some\n  <child>\n    foo\n  </child>\n  text\n</node>';\n\n$dom = new DOMDocument;\n$dom->loadXML($xmlString);\n\nfunction parseNode($node) {\n    foreach ($node->childNodes as $child) {\n        if ($child->nodeType == XML_TEXT_NODE) {\n            echo "Text: " . trim($child->nodeValue) . "\n";\n        } elseif ($child->nodeType == XML_ELEMENT_NODE) {\n            echo "Element: " . $child->nodeName . "\n";\n            parseNode($child); // Recursively parse child elements\n        }\n    }\n}\n\nparseNode($dom->documentElement);\n?>