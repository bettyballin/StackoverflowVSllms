<?php\n\n$dbhost = "localhost";\n$dbuser = "myuser";\n$dbpass = "mypass";\n$dbname = "mydb";\n\necho $dbhost . "-" . $dbuser . "-" . $dbname;\n\n// Create connection\n$conn = mysqli_connect($dbhost, $dbuser, $dbpass);\n\n// Check connection\nif (!$conn) {\n    die("Connection failed: " . mysqli_connect_error());\n}\n\necho "Connected successfully<br>";\n\n$sql = "SELECT DATABASE()";\n$result = mysqli_query($conn, $sql) or die(mysqli_error($conn));\n$row = mysqli_fetch_row($result);\necho "Current Database is: {$row[0]}<br>";\n\n// Close the connection\nmysqli_close($conn);\n\nphpinfo();\n\n?>