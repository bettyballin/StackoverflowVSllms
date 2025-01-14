function splitOutsideBrackets($string) {\n    // Regular expression pattern to match segments outside or complete with balanced brackets\n    $pattern = '/\n        (?:         # Non-capturing group\n            [^(),]+   # Match any character except parentheses and commas\n          |\n            \(        # Match a literal opening parenthesis\n            (?:       # Non-capturing group for recursion (PCRE engine supporting it)\n                [^()]*  # Any number of characters not a parenthesis\n                |\n                (?R)    # Recursive pattern to match balanced parentheses\n            )*        # Repeat as needed\n            \)        # Match a literal closing parenthesis\n        )+          # One or more repetitions of the non-capturing group\n    /x';            # Free-spacing mode for better readability\n\n    preg_match_all($pattern, $string, $matches);\n    return array_map('trim', $matches[0]);\n}\n\n$input = "one, two, three, (four, (five, six), (ten)), seven";\n$result = splitOutsideBrackets($input);\n\nprint_r($result);