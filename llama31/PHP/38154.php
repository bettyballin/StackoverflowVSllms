$array = array("apple", "banana", "cap", "dog", ...);\n$stringsToFind = array("abc", "def", "ghi");\n\nforeach ($stringsToFind as $str) {\n    if (in_array($str, $array)) {\n        echo "$str exists";\n    } else {\n        echo "$str does not exist";\n    }\n}