<?php\n// Simulated database or user array\n$existingUsers = ['user1', 'user2', 'admin'];\n\n$username = $_POST['username'] ?? '';\n\nif (!in_array($username, $existingUsers)) {\n    echo 'available';\n} else {\n    echo 'not available';\n}\n?>