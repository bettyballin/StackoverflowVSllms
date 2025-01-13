function countUppercaseWords($str) {\n    $words = explode(' ', $str);\n    $count = 0;\n    foreach ($words as $word) {\n        if (ctype_upper($word)) {\n            $count++;\n        }\n    }\n    return $count;\n}\n\n// Example usage:\n$string = "Hello WORLD this IS a TEST";\necho countUppercaseWords($string);