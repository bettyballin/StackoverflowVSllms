function extractWords($text) {\n    $text = strtolower($text);\n    $text = preg_replace('/[^\w\s]/', '', $text);\n    $words = explode(' ', $text);\n    return array_unique($words);\n}