function isClean($input) {\n    // Load your list of bad words from a file or database\n    $badWords = array('badword1', 'badword2', 'badword3');\n    \n    // Normalize the input: convert to lowercase and remove extra spaces\n    $normalizedInput = strtolower(trim($input));\n    \n    // Check each word in the normalized input against the bad words list\n    foreach (explode(" ", $normalizedInput) as $word) {\n        if (in_array($word, $badWords)) {\n            return false;\n        }\n        \n        // Also check common leetspeak variations here using regex or a dictionary\n        if (preg_match('/a[s$5]{2}|azz/a', $word)) { \n            return false;\n        }\n    }\n    \n    return true; // If no bad words are found\n}\n\n// Example usage\n$input = "This is a test a$$";\nif (!isClean($input)) {\n    echo "The input contains inappropriate language.";\n} else {\n    echo "The input is clean.";\n}