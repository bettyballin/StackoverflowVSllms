require_once 'XML/Serializer.php';\n\n// Define your array with repeated elements nested in a parent array\n$data = array(\n    'totalRooms' => array(\n        'Room' => array(\n            array(\n                'attribute1' => 'value1',\n                'attribute2' => 'value2'\n            ),\n            array(\n                'attribute1' => 'value3',\n                'attribute2' => 'value4'\n            )\n        )\n    )\n);\n\n// Set up the XML_Serializer options\n$options = array(\n    'indent' => '  ',\n    'linebreak' => "\n",\n    'rootName' => 'root',\n    'defaultTagName' => 'item'\n);\n\n// Create the serializer\n$serializer = new XML_Serializer($options);\n\n// Serialize the data\nif ($serializer->serialize($data)) {\n    // Output the XML\n    echo $serializer->getSerializedData();\n} else {\n    // Handle serialization error\n    echo 'Error serializing data!';\n}