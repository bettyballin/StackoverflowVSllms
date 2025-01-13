libxml_use_internal_errors(true);\n$doc = new DOMDocument();\n$doc->loadHTML($html);\n\n$xpath = new DOMXPath($doc);\n$elements = $xpath->query("//*[@id]");\n\n$ids = array();\nforeach ($elements as $element) {\n    $id = $element->getAttribute('id');\n    if (in_array($id, $ids)) {\n        $element->removeAttribute('id');\n    } else {\n        $ids[] = $id;\n    }\n}\n\nlibxml_clear_errors();