<?php\nsession_start(); // Start the session\n\n// Access session variables set by frontend\n$user_id = $_SESSION['user_id'];\n$role = $_SESSION['role'];\n\necho "User ID: " . $user_id;\necho "Role: " . $role;