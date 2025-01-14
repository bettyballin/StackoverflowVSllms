<?php\n$servername = "localhost";\n$username = "username";\n$password = "password";\n$dbname = "myDB";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// Prepare and bind\n$stmt = $conn->prepare("INSERT INTO calendar (event, from_time, to_time, day) VALUES (?, ?, ?, ?)");\n$stmt->bind_param("ssss", $event, $from_time, $to_time, $date_event);\n\n// Set parameters and execute\n$event = $_REQUEST['event'];\n$from_time = $_REQUEST['from_time'];\n$to_time = $_REQUEST['to_time'];\n$date_event = $_REQUEST['date_event'];\n$stmt->execute();\n\necho "New record created successfully";\n\n$stmt->close();\n$conn->close();\n?>