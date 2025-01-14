function strClean($input) {\n    // Convert to lowercase using mb_strtolower for proper multibyte character support\n    $input = mb_strtolower($input, 'UTF-8');\n    \n    // Transliterate accented characters to their non-accented counterparts\n    $input = iconv('UTF-8', 'ASCII//TRANSLIT', $input);\n\n    // Replace spaces with hyphens or any other desired character\n    $input = str_replace(' ', '-', $input);\n\n    return $input;\n}