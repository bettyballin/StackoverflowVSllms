function posix_to_pcre($pattern) {\n    $pattern = preg_quote($pattern, '/');\n    $pattern = str_replace('\{', '{', $pattern);\n    $pattern = str_replace('\}', '}', $pattern);\n    $pattern = str_replace('\(', '(', $pattern);\n    $pattern = str_replace('\)', ')', $pattern);\n    $pattern = str_replace('\[', '[', $pattern);\n    $pattern = str_replace('\]', ']', $pattern);\n    $pattern = str_replace('\.', '.', $pattern);\n    $pattern = str_replace('\*', '*', $pattern);\n    $pattern = str_replace('\+', '+', $pattern);\n    $pattern = str_replace('\?', '?', $pattern);\n    $pattern = str_replace('\^', '^', $pattern);\n    $pattern = str_replace('\$', '$', $pattern);\n    $pattern = str_replace('\|', '|', $pattern);\n    return $pattern;\n}