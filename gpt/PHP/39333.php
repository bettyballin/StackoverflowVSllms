<?php\ninclude 'test.php'; // Correctly include the file\n\nclass test1 {\n    function test2() {\n        global $config_key_security; // Access the global variable\n        echo $config_key_security; // Output the value of the variable\n    }\n}\n\n// Example usage:\n$instance = new test1();\n$instance->test2(); // This will output "test"\n?>