$str = 'result: $count';\n$count = 5;\n\n// Parse variable by replacing the placeholder with the actual value\n$str = str_replace('$count', $count, $str);\n\necho $str; // result: 5