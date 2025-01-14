function str_replace_first($search, $replace, $subject) {\n    $pos = strpos($subject, $search);\n    if ($pos !== false) {\n        return substr_replace($subject, $replace, $pos, strlen($search));\n    }\n    return $subject;\n}\n\n// Example usage:\n$originalString = "Hello world! Hello universe!";\n$newString = str_replace_first("Hello", "Hi", $originalString);\necho $newString; // Outputs: Hi world! Hello universe!