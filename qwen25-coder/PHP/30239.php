// Create a DateTime object\n$date = new DateTime('now');\n\n// Format the DateTime as a MySQL DATE\n$mysqlDate = $date->format('Y-m-d');\n\n// Example of using it with a prepared statement\n$stmt = $mysqli->prepare("INSERT INTO your_table (your_date_column) VALUES (?)");\n$stmt->bind_param("s", $mysqlDate);\n$stmt->execute();