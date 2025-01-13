function findDifferences($str1, $str2) {\n    $diff = array();\n    $len1 = strlen($str1);\n    $len2 = strlen($str2);\n    $maxLen = max($len1, $len2);\n\n    for ($i = 0; $i < $maxLen; $i++) {\n        if ($i >= $len1 || $i >= $len2 || $str1[$i] !== $str2[$i]) {\n            $diff[] = $i;\n        }\n    }\n\n    return $diff;\n}\n\n$str1 = "The brown fox jumps over the lazy dog";\n$str2 = "The quick brown fox jumped over the lazy dog";\n\n$differences = findDifferences($str1, $str2);\n\nforeach ($differences as $diff) {\n    echo "Difference at position $diff\n";\n}