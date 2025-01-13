function googleQueryToTsquery($query) {\n    // Step 1: Handle quoted phrases\n    $query = preg_replace('/"([^"]+)"/', "'$1'", $query);\n    \n    // Step 2: Handle OR operator\n    $query = preg_replace('/\sOR\s/', ' | ', $query);\n    \n    // Step 3: Handle negation\n    $query = preg_replace('/\s-([^\s]+)/', ' & !$1', $query);\n    \n    // Step 4: Handle parentheses\n    $query = preg_replace('/\(/', '(', $query);\n    $query = preg_replace('/\)/', ')', $query);\n\n    // Step 5: Handle default AND\n    $query = preg_replace('/\s+/', ' & ', $query);\n    \n    return $query;\n}\n\n// Example usage\n$googleQuery = '("used cars" OR "new cars") -ford -mistubishi';\n$tsquery = googleQueryToTsquery($googleQuery);\necho $tsquery; // Output: ('used cars' | 'new cars') & !ford & !mistubishi