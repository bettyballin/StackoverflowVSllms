function modify_string($str) {\n    // At this point, $str references the same string as the original\n    echo spl_object_id($str) . "\n";\n    \n    // Now, PHP creates a copy of the string\n    $str .= ' modified';\n    echo spl_object_id($str) . "\n";\n}\n\n$str = 'Hello';\necho spl_object_id($str) . "\n";\nmodify_string($str);