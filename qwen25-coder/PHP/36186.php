<?php\nif ($_SERVER['REQUEST_METHOD'] == 'POST') {\n    if (isset($_FILES['file'])) {\n        $path = $_POST['path'];\n        $tmpName = $_FILES['file']['tmp_name'];\n        $originalName = basename($_FILES['file']['name']);\n        $fullPath = $path . DIRECTORY_SEPARATOR . $originalName;\n\n        // Validate and then move the uploaded file\n        if (move_uploaded_file($tmpName, $fullPath)) {\n            echo "File uploaded successfully.";\n        } else {\n            echo "Failed to upload file.";\n        }\n    } else {\n        echo "No file was selected.";\n    }\n} else {\n    echo "Invalid request method.";\n}\n?>