// main_script.php\n    <?php\n    $mysqli = new mysqli("localhost", "user", "password", "database");\n\n    if ($mysqli->connect_error) {\n        die("Connection failed: " . $mysqli->connect_error);\n    }\n\n    $result = $mysqli->query("SELECT value FROM strings WHERE id=1");\n    $row = $result->fetch_assoc();\n    $var1 = $row['value'];\n\n    $mysqli->close();\n    echo $var1;\n    ?>