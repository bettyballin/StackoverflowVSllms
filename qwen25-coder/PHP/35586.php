<?php\n// Start output buffering.\nob_start();\n\n// Include or require the file whose output you want to capture.\ninclude 'another_file.php';\n\n// Capture the buffered output and clean the buffer.\n$output = ob_get_clean();\n\n// Now $output contains the echo'ed output from another_file.php\necho $output;\n?>