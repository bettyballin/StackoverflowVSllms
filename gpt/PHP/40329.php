function ltrim_custom($str, $num) {\n    return substr($str, $num);\n}\n\nfunction rtrim_custom($str, $num) {\n    return substr($str, 0, -$num);\n}\n\n$str = "[test]";\n$str = ltrim_custom($str, 1); // Becomes 'test]'\necho $str . "\n";\n$str = rtrim_custom($str, 1); // Becomes 'test'\necho $str . "\n";