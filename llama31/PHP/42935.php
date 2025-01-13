function compare_classes($c1, $c2) {\n    $methods1 = get_class_methods(get_class($c1));\n    $methods2 = get_class_methods(get_class($c2));\n\n    // Check if both classes have the same public methods\n    if (array_diff($methods1, $methods2) || array_diff($methods2, $methods1)) {\n        return false;\n    }\n\n    // Call each public method and compare the results\n    foreach ($methods1 as $method) {\n        $reflectionMethod = new ReflectionMethod($c1, $method);\n        if ($reflectionMethod->isPublic()) {\n            $result1 = $c1->$method();\n            $result2 = $c2->$method();\n            if ($result1 !== $result2) {\n                return false;\n            }\n        }\n    }\n\n    return true;\n}