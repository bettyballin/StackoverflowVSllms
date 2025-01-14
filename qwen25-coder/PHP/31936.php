// Use filter_input with FILTER_NULL_ON_FAILURE for better readability\n$checkbox1 = filter_input(INPUT_POST, 'checkbox1', FILTER_SANITIZE_STRING, FILTER_NULL_ON_FAILURE);\n$checkbox2 = filter_input(INPUT_POST, 'checkbox2', FILTER_SANITIZE_STRING, FILTER_NULL_ON_FAILURE);\n\n// Check if the checkbox was checked\nif ($checkbox1 === 'checked') {\n    // Do something when checkbox1 is checked\n}\n\nif ($checkbox2 === 'checked') {\n    // Do something when checkbox2 is checked\n}