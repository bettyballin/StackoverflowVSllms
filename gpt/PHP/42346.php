$mysqli = new mysqli("localhost", "username", "password", "database");\n\n   // Check connection\n   if ($mysqli->connect_error) {\n       die("Connection failed: " . $mysqli->connect_error);\n   }\n\n   // Set charset to UTF-8\n   if (!$mysqli->set_charset("utf8")) {\n       printf("Error loading character set utf8: %s\n", $mysqli->error);\n       exit();\n   }