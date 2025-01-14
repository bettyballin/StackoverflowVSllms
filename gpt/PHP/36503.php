<?php\n// Include the Twilio PHP library\nrequire 'path/to/twilio-php/src/Twilio/autoload.php';\n\nuse Twilio\Rest\Client;\nuse Twilio\Twiml;\n\n// Database connection settings\n$servername = "your_server";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_database";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// Get the SMS data from Twilio\n$from = $_POST['From'];\n$body = $_POST['Body'];\n\n// Sanitize input to prevent SQL injection\n$from = $conn->real_escape_string($from);\n$body = $conn->real_escape_string($body);\n\n// Insert SMS data into the database\n$sql = "INSERT INTO sms_logs (phone_number, message) VALUES ('$from', '$body')";\n\nif ($conn->query($sql) === TRUE) {\n    echo "New record created successfully";\n} else {\n    echo "Error: " . $sql . "<br>" . $conn->error;\n}\n\n// Close the connection\n$conn->close();\n?>