// PHP code snippet to connect to MySQL\n$servername = "localhost";\n$username = "username";\n$password = "password";\n$dbname = "myDB";\n\n$conn = new mysqli($servername, $username, $password, $dbname);\n\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}