function truncateText($text, $maxLength) {\n    // Check if the text length is less than or equal to the maximum length\n    if (strlen($text) <= $maxLength) {\n        return $text;\n    }\n\n    // Find the position of the last space within the maximum length\n    $truncatedText = substr($text, 0, $maxLength);\n    $lastSpacePosition = strrpos($truncatedText, ' ');\n\n    // If a space is found, truncate the text at the last space position\n    if ($lastSpacePosition !== false) {\n        $truncatedText = substr($truncatedText, 0, $lastSpacePosition);\n    }\n\n    return $truncatedText . '...';\n}\n\n// Example usage:\n$text = "This is a sample block of text that we want to truncate to the closest word before reaching the character limit.";\n$maxLength = 50;\necho truncateText($text, $maxLength);