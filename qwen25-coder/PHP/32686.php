$arr = [];\n\nforeach ($nodes as $index => $node) {\n    if ($condition) { // Ensure 'condition' is based on properties of $node\n        $arr[$index] = array("value" => $node->nodeValue);\n    } else {\n        $arr[$index] = array("string" => $node->nodeValue);\n    }\n}