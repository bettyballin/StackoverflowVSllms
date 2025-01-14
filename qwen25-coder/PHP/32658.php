function hexToTwitterFlash($hex) {\n    // Remove the '#' at the beginning if present\n    $cleanHex = ltrim($hex, '#');\n    \n    // Convert it to base 10 integer\n    return hexdec($cleanHex);\n}\n\n// Example usage:\n$colorCode = "#FF5733";\n$twitterFlashColor = hexToTwitterFlash($colorCode);\necho "The Twitter Flash color code is: {$twitterFlashColor}";