function validateEmailCC($input, $validValues) {\n    // Step 1: Explode the input string into an array using semicolon as delimiter\n    $ccArray = explode(';', $input);\n    \n    // Filter out any empty values (useful if there are trailing semicolons)\n    $ccArray = array_filter($ccArray, function($value) {\n        return trim($value) !== '';\n    });\n\n    // Step 2: Initialize error messages\n    $errors = [];\n    \n    // Step 3: Iterate over each element in the array and validate\n    foreach ($ccArray as $key => $value) {\n        // Check if the value is a numeric string\n        if (!is_numeric($value)) {\n            $errors[] = "Value at position ".($key+1)." ('".$value."') is not a valid number.";\n            continue;\n        }\n\n        // Convert to integer for comparison with database values\n        $intValue = (int)$value;\n\n        // Check if the numeric value exists in the valid values array\n        if (!in_array($intValue, $validValues)) {\n            $errors[] = "Value at position ".($key+1)." ('".$value."') is not a valid entry.";\n        }\n    }\n\n    // Step 4: Return errors if any were found\n    return empty($errors) ? true : $errors;\n}\n\n// Example usage:\n$ccInput = '1;2;3;5';\n$validDatabaseValues = [1, 2, 3, 4]; // Simulated valid values from your database\n\n$result = validateEmailCC($ccInput, $validDatabaseValues);\n\nif ($result === true) {\n    echo "All values are valid.";\n} else {\n    print_r($result); // Print the error messages\n}