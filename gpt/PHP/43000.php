<?php\nfunction findDifferences($str1, $str2) {\n    $differences = [];\n    $length1 = strlen($str1);\n    $length2 = strlen($str2);\n\n    // Get the minimum length to avoid out-of-bounds errors\n    $minLength = min($length1, $length2);\n\n    for ($i = 0; $i < $minLength; $i++) {\n        if ($str1[$i] !== $str2[$i]) {\n            $differences[] = $i;\n        }\n    }\n\n    // Handle the case where the strings are of different lengths\n    if ($length1 !== $length2) {\n        for ($i = $minLength; $i < max($length1, $length2); $i++) {\n            $differences[] = $i;\n        }\n    }\n\n    return $differences;\n}\n\n$str1 = "The brown fox jumps over the lazy dog";\n$str2 = "The quick brown fox jumped over the lazy dog";\n\n$differences = findDifferences($str1, $str2);\n\nprint_r($differences);\n?>