function limit_text($text, $limit) {\n    if (strlen($text) <= $limit)\n        return $text;\n\n    $words = str_word_count($text, 2);\n    $pos = array_keys($words);\n    $last_key = array_key_last($pos);\n    if ($last_key < $limit) {\n        return $text;\n    }\n    return substr($text, 0, $pos[$limit]) . '...';\n}