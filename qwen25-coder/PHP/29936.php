include("conn.php"); // Assume this sets up a connection to the database\n\n// Assuming $conn is your mysqli connection object\n$result = $conn->query("SELECT * FROM sggame");\n\nwhile($row = $result->fetch_assoc()) {\n    $id = $row['id'];\n    echo $id;\n    echo 'working?';\n}