<?php\nob_start(); // Start output buffering\ninclude 'myfile2.php'; // Include the PHP file you want to capture the output from\n$captured_output = ob_get_clean(); // Get the contents of the output buffer and clean it\n\necho $captured_output; // Optional: Display the captured output\n?>