$arr = [];\n\nfor ($i = 0; $i < count($nodes); $i++) {\n    if ($condition) { // Make sure 'condition' is properly defined and evaluates to true/false\n        $arr[$i] = array("value" => $node->nodeValue);\n    } else {\n        $arr[$i] = array("string" => $node->nodeValue);\n    }\n}