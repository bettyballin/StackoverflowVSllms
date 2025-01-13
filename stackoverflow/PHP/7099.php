function limit_text($text, $limit) {\n    if (str_word_count($text, 0) > $limit) {\n        $words = str_word_count($text, 2);\n        $pos   = array_keys($words);\n        $text  = substr($text, 0, $pos[$limit]) . '...';\n    }\n    return $text;\n}\n\necho limit_text('Hello here is a long sentence that will be truncated by the', 5);