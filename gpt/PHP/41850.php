<?php\n$servername = "your_servername";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_dbname";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n$sql = "UPDATE `messages` SET `new`='Y', `read`='N', `locked`='N' WHERE `recipient_id`=1";\n\nif ($conn->query($sql) === TRUE) {\n    if ($conn->affected_rows > 0) {\n        echo "Records updated successfully";\n    } else {\n        echo "No records were updated";\n    }\n} else {\n    echo "Error updating record: " . $conn->error;\n}\n\n$conn->close();\n?>