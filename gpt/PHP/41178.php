// Create a new DateTime object or use an existing one\n$dateTime = new DateTime();\n\n// Format the DateTime object to a MySQL date string\n$mysqlDateString = $dateTime->format('Y-m-d');\n\n// Now you can use this string in your prepared statement\n$stmt = $mysqli->prepare("INSERT INTO your_table (your_date_column) VALUES (?)");\n$stmt->bind_param("s", $mysqlDateString);\n$stmt->execute();\n$stmt->close();