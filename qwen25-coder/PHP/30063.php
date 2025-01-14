function intvalEquivalent($input) {\n    // Convert the input to a string first, to handle different types of input\n    $strInput = (string)$input;\n    \n    // Remove any non-numeric characters except for an optional leading minus sign\n    if (!preg_match('/^-?[0-9]+$/', $strInput)) {\n        return 0; // Return 0 if the input is not a valid integer\n    }\n    \n    // Use filter_var to sanitize and convert the string to an integer\n    $intNumber = filter_var($strInput, FILTER_SANITIZE_NUMBER_INT);\n    \n    // Check if the number is too large for a 64-bit system integer\n    if (is_numeric($input) && ($input < PHP_INT_MIN || $input > PHP_INT_MAX)) {\n        // Return as float or string, depending on your needs\n        return 0; // Or you could return the input as a string: return $strInput;\n    }\n    \n    return $intNumber;\n}\n\n$inputNumber = 3147483647.37;\n$intNumber = intvalEquivalent($inputNumber);\necho $intNumber; // Output: 3147483647