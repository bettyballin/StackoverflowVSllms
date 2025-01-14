function sqlLikeMatch($pattern, $subject) {\n    // Escape special characters except for the percent sign (%)\n    // which represents zero or more characters in SQL LIKE syntax.\n    $pattern = preg_quote($pattern, '/');\n    \n    // Replace '%' with '.*' to represent any number of characters.\n    $pattern = str_replace('%', '.*', $pattern);\n    \n    // Anchor the pattern at the start (^) if needed by your use case.\n    // In this case, since you mentioned "LIKE 'matchme%'", we start with ^.\n    $pattern = '^' . $pattern;\n    \n    // Use preg_match to perform the match.\n    return (bool)preg_match('/' . $pattern . '/i', $subject);\n}\n\n// Example usage:\n$inputString = "matchmetoo";\n$searchPattern = "matchme%";\nif (sqlLikeMatch($searchPattern, $inputString)) {\n    echo "Match found!";\n} else {\n    echo "No match.";\n}