<?php\n$mysqli = new mysqli("host", "user", "password", "database");\n\nif ($mysqli->connect_error) {\n    die('Connect Error (' . $mysqli->connect_errno . ') '\n            . $mysqli->connect_error);\n}\n\n// Perform database operations here\n\n$query1 = $mysqli->query("SELECT * FROM table");\n// process result\n$query2 = $mysqli->query("INSERT INTO table VALUES (value1, value2)");\n// check success\n\n$mysqli->close();\n?>