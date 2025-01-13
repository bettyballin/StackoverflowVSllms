<?php\n$servername = "your_server";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_database";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// Get IP address of the client\n$ip_address = $_SERVER['REMOTE_ADDR'];\n\n// Insert IP address into the database\n$stmt = $conn->prepare("INSERT INTO ip_addresses (ip_address) VALUES (?)");\n$stmt->bind_param("s", $ip_address);\n$stmt->execute();\n$stmt->close();\n\n// Retrieve the last X IP addresses including the current one\n$X = 5; // Adjust the number of IP addresses to retrieve\n$sql = "SELECT ip_address FROM ip_addresses ORDER BY timestamp DESC LIMIT ?";\n$stmt = $conn->prepare($sql);\n$stmt->bind_param("i", $X);\n$stmt->execute();\n$result = $stmt->get_result();\n\n$ip_addresses = [];\nwhile ($row = $result->fetch_assoc()) {\n    $ip_addresses[] = $row['ip_address'];\n}\n\n$stmt->close();\n$conn->close();\n\n// Display the IP addresses\necho "<p>Last $X IP addresses (most recent first):</p>";\necho "<ul>";\nforeach ($ip_addresses as $ip) {\n    echo "<li>$ip</li>";\n}\necho "</ul>";\n?>