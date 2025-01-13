// Configuration\n$db_host = 'your_host';\n$db_username = 'your_username';\n$db_password = 'your_password';\n$db_name = 'your_database';\n$table_name = 'your_table';\n\n// Connect to the database\n$conn = mysqli_connect($db_host, $db_username, $db_password, $db_name);\n\n// Check connection\nif (!$conn) {\n    die("Connection failed: " . mysqli_connect_error());\n}\n\n// Export the data\n$result = mysqli_query($conn, "SELECT * FROM $table_name");\n\n// Create a CSV file\n$fp = fopen('export.csv', 'w');\n\n// Write the data to the CSV file\nwhile ($row = mysqli_fetch_assoc($result)) {\n    fputcsv($fp, $row);\n}\n\n// Close the CSV file\nfclose($fp);\n\n// Close the database connection\nmysqli_close($conn);