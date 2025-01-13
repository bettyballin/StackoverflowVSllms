<?php\n$page = basename($_GET['page']); // This will remove any directory path\nif (!preg_match('/^[a-zA-Z0-9\-_]+$/', $page)) {\n    die('Incorrect page supplied.');\n}\n\n$file = $page . '.php';\nif (!file_exists($file)) {\n    die('File does not exist.');\n}\n\nob_start('changeOutput');\ninclude($file);\nob_end_flush();\n\nfunction changeOutput($buffer) {\n    // Your output modification code here\n}\n?>