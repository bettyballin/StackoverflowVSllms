$needle = 'VALUE';\n$haystack = ['value1', 'Value2', 'VALUE3'];\n\n$found = in_array(strtolower($needle), array_map('strtolower', $haystack));\n\nif ($found) {\n    echo 'Value found!';\n} else {\n    echo 'Value not found.';\n}