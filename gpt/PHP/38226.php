<?php\nif ($_SERVER['REQUEST_METHOD'] === 'POST') {\n    // Directory where we want to save uploaded files\n    $uploadDir = 'uploads/';\n\n    // Check if the upload directory exists, if not create it\n    if (!is_dir($uploadDir)) {\n        mkdir($uploadDir, 0777, true);\n    }\n\n    // Loop through each file\n    foreach ($_FILES['files']['name'] as $key => $name) {\n        // Check for upload errors\n        if ($_FILES['files']['error'][$key] === UPLOAD_ERR_OK) {\n            // Ensure the file is a valid image\n            $fileType = mime_content_type($_FILES['files']['tmp_name'][$key]);\n            if (in_array($fileType, ['image/jpeg', 'image/png', 'image/gif'])) {\n                // Move the file to the upload directory\n                $filePath = $uploadDir . basename($name);\n                if (move_uploaded_file($_FILES['files']['tmp_name'][$key], $filePath)) {\n                    echo "File {$name} uploaded successfully.<br>";\n                } else {\n                    echo "Failed to upload file {$name}.<br>";\n                }\n            } else {\n                echo "Invalid file type for {$name}. Only JPG, JPEG, PNG, and GIF are allowed.<br>";\n            }\n        } else {\n            echo "Error uploading {$name}.<br>";\n        }\n    }\n}\n?>