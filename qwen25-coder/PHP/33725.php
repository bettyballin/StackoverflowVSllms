$parsedArguments = array_map('trim', preg_match_all('/(?:\'([^\'\\\\]*(?:\\\\.[^\'\\\\]*)*)\'|"([^"\\\\]*(?:\\\\.[^"\\\\]*)*)"|(\S+))/', $input, $matches));\n$result = array_filter(array_merge($matches[1], $matches[2], $matches[3]));\nprint_r($result);