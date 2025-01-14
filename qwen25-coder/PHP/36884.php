<?php\n// Initialize the XML document\n$xml = new SimpleXMLElement('<site/>');\n\nfunction createXMLnode(\SimpleXMLElement $xml, \PageArray $items) {\n    foreach ($items as $item) {\n        // Create a node for each item in PageArray\n        $childNode = $xml->addChild('page');\n        \n        foreach ($item->template->getFields() as $field) {\n            $fieldName = $field->name();\n            if ($field->type instanceof FieldtypeImages || $field->type instanceof FieldtypePageimages) {\n                // Handle image fields\n                $children = $childNode->addChild($fieldName);\n                foreach ($item->$fieldName as $file) {\n                    $children->addChild('url', $file->url);\n                }\n            } elseif ($field->type instanceof FieldtypeRepeater || $field->type instanceof FieldtypePageArray) {\n                // Handle repeater or pagearray fields\n                $children = $childNode->addChild($fieldName);\n                createXMLnode($children, $item->$fieldName);\n            } else {\n                // Regular field types\n                $childNode->addChild($fieldName, $item->$fieldName);\n            }\n        }\n    }\n}\n\n// Fetch pages and convert to XML\ncreateXMLnode($xml, wire('pages')->find('/'));\n\n// Output as a string of XML:\nEcho $xml->asXML();\n?>