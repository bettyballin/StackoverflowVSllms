<?php\n$servername = "localhost";\n$username = "username";\n$password = "password";\n$dbname = "database_name";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\nif ($_SERVER["REQUEST_METHOD"] == "POST") {\n    if (isset($_FILES['image']) && $_FILES['image']['error'] === UPLOAD_ERR_OK) {\n        // Verify file is an image\n        $check = getimagesize($_FILES['image']['tmp_name']);\n        if ($check !== false) {\n            // Read the uploaded image content\n            $image_data = file_get_contents($_FILES['image']['tmp_name']);\n\n            // Prepare and bind\n            $stmt = $conn->prepare("INSERT INTO images (image_data) VALUES (?)");\n            $stmt->bind_param("b", $image_data);\n\n            // Execute the statement\n            if ($stmt->execute()) {\n                echo "New record created successfully";\n            } else {\n                echo "Error: " . $stmt->error;\n            }\n\n            $stmt->close();\n        } else {\n            echo "File is not an image.";\n        }\n    }\n}\n\n$conn->close();\n?>