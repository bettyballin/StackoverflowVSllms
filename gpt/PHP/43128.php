function isFiveDigitNumber($number) {\n    $pattern = '/^\d{5}$/';\n    return preg_match($pattern, $number) === 1;\n}\n\n// Example usage\n$number = "12345";\nif (isFiveDigitNumber($number)) {\n    echo "The number consists of exactly 5 digits.";\n} else {\n    echo "The number does not consist of exactly 5 digits.";\n}