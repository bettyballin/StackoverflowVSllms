function cleanString($var) {\n    // Remove ' (as ...)' if present\n    $var = preg_replace('/ \(as .*\)/', '', $var);\n    // If the string starts with '(' and contains spaces, extract the first word inside the parentheses\n    if (preg_match('/^\(([^ ]+).*\)$/', $var, $matches)) {\n        return $matches[1];\n    }\n    // As a last resort, just take the first word of the string\n    return preg_replace('/^(.*?) .*?$/', '$1', $var);\n}\n\n// Test cases\n$testStrings = [\n    'Tom Greenleaf (as John Dunn Hill)',\n    '(screenplay) (as The Wibberleys) &',\n    '(novella "Four Past Midnight: Secret Window, Secret Garden")'\n];\n\nforeach ($testStrings as $string) {\n    echo cleanString($string) . "\n";\n}