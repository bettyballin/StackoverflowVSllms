<?php\n// db_connect.php\n$GLOBALS['mysqli'] = new mysqli("localhost", "username", "password", "database");\n\nif ($GLOBALS['mysqli']->connect_error) {\n    die("Connection failed: " . $GLOBALS['mysqli']->connect_error);\n}\n?>