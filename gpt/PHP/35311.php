$arrayOne = [1, 2, 3, 4, 5];\n\nwhile (!empty($arrayOne)) {\n    foreach ($arrayOne as $key => $value) {\n        // Perform your function that may modify $arrayOne\n        if ($value % 2 == 0) { // Example condition to remove even numbers\n            unset($arrayOne[$key]);\n        }\n    }\n    \n    // Reset array keys after modifications\n    $arrayOne = array_values($arrayOne);\n}