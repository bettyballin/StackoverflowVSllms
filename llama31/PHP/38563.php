// Configuration\n$db_host = 'your_host';\n$db_username = 'your_username';\n$db_password = 'your_password';\n$db_name = 'your_database';\n\n// Create a connection to the database\n$conn = new mysqli($db_host, $db_username, $db_password, $db_name);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// Function to create a new user\nfunction create_user($email, $password) {\n    global $conn;\n    $password_hash = password_hash($password, PASSWORD_DEFAULT);\n    $query = "INSERT INTO users (email, password) VALUES (?, ?)";\n    $stmt = $conn->prepare($query);\n    $stmt->bind_param("ss", $email, $password_hash);\n    $stmt->execute();\n    $stmt->close();\n}\n\n// Function to authenticate a user\nfunction authenticate_user($email, $password) {\n    global $conn;\n    $query = "SELECT password FROM users WHERE email = ?";\n    $stmt = $conn->prepare($query);\n    $stmt->bind_param("s", $email);\n    $stmt->execute();\n    $stmt->bind_result($stored_password);\n    $stmt->fetch();\n    $stmt->close();\n    return password_verify($password, $stored_password);\n}\n\n// Create a new user\n$email = 'user@example.com';\n$password = 'example_password';\ncreate_user($email, $password);\n\n// Authenticate a user\nif (authenticate_user($email, $password)) {\n    echo "Login successful!";\n} else {\n    echo "Invalid credentials.";\n}