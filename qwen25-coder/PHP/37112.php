function getLeafNodes($array) {\n    $stack = new SplStack();\n    $葉Nodes = [];\n\n    // Push the initial array onto the stack\n    $stack->push($array);\n\n    while (!$stack->isEmpty()) {\n        $currentElement = $stack->pop();\n\n        if (is_array($currentElement)) {\n            foreach ($currentElement as $element) {\n                $stack->push($element);\n            }\n        } else {\n            // This is a leaf node\n            $leafNodes[] = $currentElement;\n        }\n    }\n\n    return $leafNodes;\n}\n\n// Example usage:\n$array = [\n    [0 => [[new stdClass()]]],\n    [2 => [[new stdClass()]]]\n];\n\n$result = getLeafNodes($array);\nprint_r($result);