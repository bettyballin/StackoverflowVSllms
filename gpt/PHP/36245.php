// Initialize variables\n$myArray = array(); // Expecting an array\n$myString = NULL;  // Expecting a string that might be NULL\n$myFlag = FALSE;   // A boolean flag\n\n// Check if a variable is set and not NULL\nif (isset($myString)) {\n    // Do something\n}\n\n// Check if a variable is empty\nif (empty($myArray)) {\n    // Do something\n}\n\n// Strict comparison\nif ($myFlag === FALSE) {\n    // Do something\n}