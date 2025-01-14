<?php\n// Database 1 connection\n$hostname_db1 = "localhost";\n$username_db1 = "user1";\n$password_db1 = "pass1";\n$dbname_db1 = "database1";\n\n$dbh1 = new mysqli($hostname_db1, $username_db1, $password_db1, $dbname_db1);\nif ($dbh1->connect_error) {\n    die("Connection failed: " . $dbh1->connect_error);\n}\n\n// Database 2 connection\n$hostname_db2 = "localhost";\n$username_db2 = "user2";\n$password_db2 = "pass2";\n$dbname_db2 = "database2";\n\n$dbh2 = new mysqli($hostname_db2, $username_db2, $password_db2, $dbname_db2);\nif ($dbh2->connect_error) {\n    die("Connection failed: " . $dbh2->connect_error);\n}\n\n// Fetch data from Database 1\n$result1 = $dbh1->query("SELECT * FROM table1");\nwhile($row = $result1->fetch_assoc()) {\n    echo "From DB1: " . $row['column_name'] . "<br>";\n}\n\n// Fetch data from Database 2\n$result2 = $dbh2->query("SELECT * FROM table2");\nwhile($row = $result2->fetch_assoc()) {\n    echo "From DB2: " . $row['column_name'] . "<br>";\n}\n\n// Close connections\n$dbh1->close();\n$dbh2->close();\n?>