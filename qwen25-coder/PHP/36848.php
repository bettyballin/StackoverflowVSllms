ob_start(); // Start output buffering\n\n// Call var_dump() with whatever variable you want to dump\nvar_dump($yourVariable);\n\n$output = ob_get_clean(); // Get the buffered contents and clean (stop) buffering\n\necho $output; // Now you have the var_dump as a string in $output