<?php\n// User's password input during login\n$password = 'user_password';\n\n// Hashed password retrieved from the database\n$hashedPasswordFromDb = '$2y$10$eW5aGm4A1HJd3I1v8GZbNuFJ9kmK9MY7zYVtZ1VmU6N7Xj2l2X7Ai'; // Example hashed password\n\n// Verify the password\nif (password_verify($password, $hashedPasswordFromDb)) {\n    echo 'Password is valid!';\n} else {\n    echo 'Invalid password.';\n}\n?>