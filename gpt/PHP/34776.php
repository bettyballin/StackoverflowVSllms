<?php\nif (isset($_POST['upload']) && isset($_FILES['userfile']) && $_FILES['userfile']['size'] > 0) {\n    $fileName = $_FILES['userfile']['name'];\n    $tmpName  = $_FILES['userfile']['tmp_name'];\n    $fileSize = $_FILES['userfile']['size'];\n    $fileType = $_FILES['userfile']['type'];\n\n    // Validate file type and size here if needed\n\n    // Read file content securely\n    $fp = fopen($tmpName, 'r');\n    $content = fread($fp, filesize($tmpName));\n    fclose($fp);\n\n    // Use addslashes() to escape special characters\n    $content = addslashes($content);\n\n    // Database connection\n    $host = 'your_host';\n    $user = 'your_username';\n    $password = 'your_password';\n    $dbname = 'your_database';\n\n    $conn = new mysqli($host, $user, $password, $dbname);\n\n    if ($conn->connect_error) {\n        die("Connection failed: " . $conn->connect_error);\n    }\n\n    // Prepared statement to prevent SQL injection\n    $stmt = $conn->prepare("INSERT INTO upload (name, size, type, content) VALUES (?, ?, ?, ?)");\n    $stmt->bind_param('sibs', $fileName, $fileSize, $fileType, $content);\n\n    if ($stmt->execute()) {\n        echo "<br>File $fileName uploaded successfully<br>";\n    } else {\n        echo "Error: " . $stmt->error;\n    }\n\n    // Close the statement and the connection\n    $stmt->close();\n    $conn->close();\n}\n?>