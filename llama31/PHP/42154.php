$password = "MySecurePassword!";\n\n// Split the string into an array of individual characters\n$chars = str_split($password);\n\n// Loop through the array and check for at least one capital and one symbol/number\n$hasCapital = false;\n$hasSymbolOrNumber = false;\nforeach ($chars as $char) {\n    if (ctype_upper($char)) {\n        $hasCapital = true;\n    } elseif (!ctype_alpha($char)) {\n        $hasSymbolOrNumber = true;\n    }\n}\n\n// Check if the password meets the requirements\nif ($hasCapital && $hasSymbolOrNumber) {\n    echo "Password is valid!";\n} else {\n    echo "Password is not valid.";\n}