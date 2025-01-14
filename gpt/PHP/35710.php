<?php\nfunction hexToDecimalColor($hex) {\n    // Remove the hash at the start if it's there\n    $hex = ltrim($hex, '#');\n\n    // Ensure the hex code is valid\n    if(strlen($hex) != 6) {\n        throw new Exception('Invalid hex color code');\n    }\n\n    // Convert hex color to decimal\n    $r = hexdec(substr($hex, 0, 2));\n    $g = hexdec(substr($hex, 2, 2));\n    $b = hexdec(substr($hex, 4, 2));\n\n    // Combine the values into a single decimal number\n    $decimalColor = ($r << 16) + ($g << 8) + $b;\n\n    return $decimalColor;\n}\n\n// Example usage\n$hexColor = "#ffcc00";\n$decimalColor = hexToDecimalColor($hexColor);\necho $decimalColor;  // Outputs 16763904\n?>