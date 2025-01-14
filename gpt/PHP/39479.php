<?php\n// Initialize the array\n$arr = array();\n\n// Example condition and nodes\n$someLimit = 10;\n$nodes = array(\n    (object) ['nodeValue' => 'abc'],\n    (object) ['nodeValue' => '0,999'],\n    (object) ['nodeValue' => 'meh'],\n    (object) ['nodeValue' => '0,123'],\n    (object) ['nodeValue' => 'xxx'],\n    (object) ['nodeValue' => 'xxx']\n);\n\n// Example loop with condition\nfor ($i = 0; $i < count($nodes); $i++) {\n    $node = $nodes[$i];\n    if ($i % 2 == 0) { // Example condition: even index\n        $arr[] = array("string" => $node->nodeValue);\n    } else { // Example condition: odd index\n        $arr[] = array("value" => $node->nodeValue);\n    }\n}\n\n// Print the resulting array\nprint_r($arr);\n?>