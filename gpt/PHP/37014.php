<?php\n$servername = "your_servername";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_dbname";\n\n$conn = new mysqli($servername, $username, $password, $dbname);\n\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\nif (isset($_POST['email'])) {\n    $email = $_POST['email'];\n    $stmt = $conn->prepare("SELECT COUNT(*) FROM users WHERE email = ?");\n    $stmt->bind_param("s", $email);\n    $stmt->execute();\n    $stmt->bind_result($count);\n    $stmt->fetch();\n    $stmt->close();\n    \n    if ($count > 0) {\n        echo "Email is already taken.";\n    } else {\n        echo "Email is available.";\n    }\n}\n\n$conn->close();\n?>