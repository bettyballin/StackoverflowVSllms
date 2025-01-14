function arrayToXml($data, &$xmlData) {\n    foreach($data as $key => $value) {\n        if(is_numeric($key)){\n            $key = 'item';\n        }\n        if(is_array($value)) {\n            $subnode = $xmlData->addChild($key);\n            arrayToXml($value, $subnode);\n        } else {\n            $xmlData->addChild("$key", htmlspecialchars("$value"));\n        }\n    }\n}\n\n$items = array("1", "2", array("item3.1" => "3.1", "item3.2" => "3.2", "isawesome" => true));\n\n$xmlData = new SimpleXMLElement('<?xml version="1.0"?><items></items>');\narrayToXml($items, $xmlData);\n$xml = $xmlData->asXML();\n\necho $xml;