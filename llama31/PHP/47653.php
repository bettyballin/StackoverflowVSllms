$allVars = get_defined_vars();\n$template = file_get_contents('myFile.txt');\n$newContents = strtr($template, array(\n    '${' . implode('}', array_keys($allVars)) . '}' => array_values($allVars),\n));