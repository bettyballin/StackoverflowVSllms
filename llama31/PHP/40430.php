$array = $_POST; // assuming your form data is in the $_POST superglobal\n\n$filtered_array = array_filter($array);\n\nif (count($array) !== count($filtered_array)) {\n    // there were empty values, stop submission and show error message\n} else {\n    // all values are filled, continue with submission\n}