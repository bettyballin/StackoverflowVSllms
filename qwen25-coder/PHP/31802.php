<?php\ninclude 'header.php';\n\nif (!is_object($db)) {\n    die("Database connection failed.");\n}\n\n$id = $db->real_escape_string($_GET['id']);\n$user_res = $db->query("SELECT * FROM users WHERE id = $id");\n$user = $user_res->fetch_assoc();\n?>\n\n<h1><?php echo htmlspecialchars($user['username']); ?>'s Profile</h1>\n\n<?php\ninclude 'footer.php';\n?>