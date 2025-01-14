function tokenizeExpression($expression) {\n    // Define a pattern that matches numbers and operators\n    $pattern = '/(\d+|\+|\-|\*|\/|\(|\))/';\n    \n    // Use preg_split with PREG_SPLIT_DELIM_CAPTURE to capture the delimiters\n    $tokens = preg_split($pattern, $expression, -1, PREG_SPLIT_NO_EMPTY | PREG_SPLIT_DELIM_CAPTURE);\n    \n    return $tokens;\n}\n\n// Example usage\n$expression = "3 + 5 * (2 - 8)";\n$tokens = tokenizeExpression($expression);\n\nprint_r($tokens);