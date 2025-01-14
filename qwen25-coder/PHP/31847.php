$conn = mysqli_connect("localhost", "username", "password", "database");\n\nif (!$conn) {\n    die("Connection failed: " . mysqli_connect_error());\n}\n\n$username = 'doesnotexist';\n$sql = "SELECT * FROM users WHERE username = ?";\n$stmt = mysqli_prepare($conn, $sql);\nmysqli_stmt_bind_param($stmt, "s", $username);\nmysqli_stmt_execute($stmt);\n\n$result = mysqli_stmt_get_result($stmt);\n\nif (!$result) {\n    echo "<p>Query execution failed: " . mysqli_error($conn) . "</p>";\n} elseif (mysqli_num_rows($result) == 0) {\n    echo "<p>NOT FOUND!</p>";\n} else {\n    echo "<p>FOUND!</p>";\n}\n\nmysqli_stmt_close($stmt);\nmysqli_close($conn);