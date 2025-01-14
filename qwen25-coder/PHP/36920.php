<?php\n\nfunction isMultilingualAlphabetic($string) {\n    // Set the internal encoding to UTF-8 just in case\n    mb_internal_encoding('UTF-8');\n\n    $length = mb_strlen($string, 'UTF-8');\n    for ($i = 0; $i < $length; $i++) {\n        $char = mb_substr($string, $i, 1, 'UTF-8');\n        // Check if the character is alphabetic using IntlChar\n        if (!IntlChar::isalpha(ord($char))) {\n            return false;\n        }\n    }\n    return true;\n}\n\n// Test with different languages\n$chinese = "你好"; // Chinese for "Hello"\n$russian = "Привет"; // Russian for "Hello"\n\necho isMultilingualAlphabetic($chinese) ? 'Chinese text is alphabetic' : 'Not alphabetic';\necho "\n";\necho isMultilingualAlphabetic($russian) ? 'Russian text is alphabetic' : 'Not alphabetic';\n?>