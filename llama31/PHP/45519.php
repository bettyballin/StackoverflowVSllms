<?php\n$dbhost = "localhost";\n$dbuser = "myuser";\n$dbpass = "mypass";\n$dbname = "mydb";\n\necho($dbhost . "-" . $dbuser . "-" . $dbpass . "-" . $dbname);\n\n$conn = new mysqli($dbhost, $dbuser, $dbpass, $dbname);\n\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\necho "Connected successfully";\n\n$conn->close();\n\nphpinfo();\n?>