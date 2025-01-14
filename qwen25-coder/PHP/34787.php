#!/usr/bin/php\n<?php\n\n// Connect toMySQL\n$dbHost = 'localhost';\n$dbUsername = 'user';\n$dbPassword = 'pass';\n$dbName = 'database_name';\n\n$conn = new mysqli($dbHost, $dbUsername, $dbPassword, $dbName);\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// Read the email content\n$fd = fopen("/proc/self/fd/0", "r");\n$emailContent = "";\nwhile (!feof($fd)) {\n    $emailContent .= fread($fd, 1024);\n}\nfclose($fd);\n\n// Extract data from the email (this example assumes data is in the first line of the body)\n$lines = explode("\n", $emailContent);\n$dataLineIndex = 6; // Typically, headers end at around index 5. Adjust according to your email structure.\n$dataToInsert = trim($lines[$dataLineIndex]);\n\n// Insert into database\n$stmt = $conn->prepare("INSERT INTO table_name (column_name) VALUES (?)");\n$stmt->bind_param("s", $dataToInsert);\n\nif ($stmt->execute()) {\n    echo "Data inserted successfully.\n";\n} else {\n    echo "Error: " . $ stmt->error;\n}\n\n// Close connection\n$stmt->close();\n$conn->close();\n\n?>