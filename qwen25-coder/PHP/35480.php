$servername = "localhost"; // Change to localhost:1186 if necessary\n$username = "user";\n$password = "password";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\necho "Connected successfully";