<?php\n$originalString = "0123456789012345";\n$formattedString = chunk_split($originalString, 4, '-');\n// Remove the trailing hyphen that chunk_split adds\n$formattedString = rtrim($formattedString, '-');\necho $formattedString; // Outputs: 0123-4567-8901-2345\n?>