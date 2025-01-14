<?php\n\n$data = ['%fullname%' => 'Joe Bloggs']; // Your data array\n\n// Read the entire file content at once\n$fileContent = @file_get_contents('email.html');\n\nif ($fileContent === false) {\n    die("Failed to open and read the email template.");\n}\n\nforeach ($data as $tag => $replacement) {\n    $fileContent = str_replace($tag, $replacement, $fileContent);\n}\n\n// Now $fileContent has all tags replaced\necho $fileContent;\n\n?>