function object_to_xml($object, $rootElement = null) {\n    if (is_null($rootElement)) {\n        $rootElement = 'root';\n    }\n\n    $xml = new SimpleXMLElement("<?xml version='1.0' encoding='UTF-8'?><$rootElement></$rootElement>");\n\n    array_to_xml(is_array($object) ? $object : get_object_vars($object), $xml);\n\n    return $xml->asXML();\n}\n\nfunction array_to_xml($array, &$xml) {\n    foreach ($array as $key => $value) {\n        if (is_array($value) || is_object($value)) {\n            $node = $xml->addChild(is_numeric($key) ? 'item' : $key);\n            array_to_xml($value, $node);\n        } else {\n            $xml->addChild(is_numeric($key) ? 'item' : $key, $value);\n        }\n    }\n}\n\n// Example usage\nclass MyObject {\n    public $name = "John Doe";\n    public $age = 30;\n    public $children = array(\n        array('name' => 'Jane Doe', 'age' => 10),\n        array('name' => 'Doe Junior', 'age' => 7)\n    );\n}\n\n$myObject = new MyObject();\n$xmlString = object_to_xml($myObject, 'Person');\necho $xmlString;