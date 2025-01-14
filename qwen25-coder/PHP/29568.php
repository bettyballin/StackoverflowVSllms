function tokenizer($text) {\n    // Convert text to lowercase\n    $text = mb_strtolower($text, 'UTF-8');\n    \n    // Use UTF-8 compatible regular expression for splitting\n    $punctuation = '/[\p{P}\p{S}]+/u'; // Matches any punctuation or symbol\n    \n    // Split the text and filter out empty elements\n    $result = preg_split($punctuation, $text, -1, PREG_SPLIT_NO_EMPTY);\n    \n    return $result;\n}\n\n$text = 'This is an example text, it contains commas and full-stops. Exclamation marks, too! Question marks? All punctuation marks you know.';\nprint_r(tokenizer($text));