<?php\n// Database connection settings\n$servername = "your_server";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_database";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// Define the query to retrieve data from the table\n$sql = "SELECT * FROM your_table";\n$result = $conn->query($sql);\n\nif ($result->num_rows > 0) {\n    // Set headers to download the file as CSV\n    header('Content-Type: text/csv');\n    header('Content-Disposition: attachment;filename=export.csv');\n\n    // Open output stream\n    $output = fopen('php://output', 'w');\n\n    // Fetch and output the column names\n    $fields = $result->fetch_fields();\n    $headers = array();\n    foreach ($fields as $field) {\n        $headers[] = $field->name;\n    }\n    fputcsv($output, $headers);\n\n    // Fetch and output the rows\n    while ($row = $result->fetch_assoc()) {\n        fputcsv($output, $row);\n    }\n\n    // Close the file pointer\n    fclose($output);\n} else {\n    echo "No records found.";\n}\n\n$conn->close();\n?>