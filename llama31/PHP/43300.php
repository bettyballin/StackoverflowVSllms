$string = "This is my test case for an example.";\n$words = explode(' ', $string);\n$result = [];\n\nfor ($i = 0; $i < count($words) - 1; $i++) {\n    $result[] = $words[$i] . ' ' . $words[$i + 1];\n}\n\n// Add the last word with the last word itself to maintain consistency\n$result[] = $words[count($words) - 1];\n\nprint_r($result);