<?php\nheader("content-type:text/plain");\n\n$servername = "localhost";\n$username = "root";\n$password = "xxxx";\n$database = "tf2faq";\n$backupFile = 'loadoutitmsfx.csv';\n\n// Create connection\n$conn = new mysqli($servername, $username, $password);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\necho "Server connection created\n";\n\n// Create database\n$sql = "CREATE DATABASE IF NOT EXISTS $database";\nif ($conn->query($sql) === TRUE) {\n    echo "Database $database created\n";\n} else {\n    echo "Database $database create failed: " . $conn->error . "\n";\n}\n\n// Select database\n$conn->select_db($database);\n\n// Create table\n$sql = "CREATE TABLE IF NOT EXISTS loadoutitems (\n    item TEXT NULL,\n    class TEXT NULL,\n    type TEXT NULL,\n    replaces TEXT NULL,\n    itempos TEXT NULL,\n    modpos TEXT NULL,\n    modneg TEXT NULL,\n    imgurl TEXT NULL,\n    notes TEXT NULL\n) ENGINE=MyISAM";\n\nif ($conn->query($sql) === TRUE) {\n    echo "Table loadoutitems created\n";\n} else {\n    echo "Table loadoutitems create failed: " . $conn->error . "\n";\n}\n\n// Load data from CSV file\n$sql = "LOAD DATA INFILE '$backupFile' INTO TABLE loadoutitems \n        FIELDS TERMINATED BY ',' \n        LINES TERMINATED BY '\n' \n        IGNORE 1 LINES";\n\nif ($conn->query($sql) === TRUE) {\n    echo "Data load passed\n";\n} else {\n    echo "Data load failed: " . $conn->error . "\n";\n}\n\n$conn->close();\n?>