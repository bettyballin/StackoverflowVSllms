$mysqli = new mysqli("your_host", "your_user", "your_password", "your_database");\n\nif ($mysqli->connect_error) {\n    die("Connection failed: " . $mysqli->connect_error);\n}\n\n$query = "SELECT COUNT(DISTINCT `users_id`) AS `num_users` FROM `users_table`";\n$result = $mysqli->query($query);\n\nif ($result) {\n    $row = $result->fetch_assoc();\n    $nr_of_users = $row['num_users'];\n} else {\n    $nr_of_users = 0;\n}\n\n$mysqli->close();