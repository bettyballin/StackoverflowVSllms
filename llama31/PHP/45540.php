<?php\n// Configuration\n$uploadDir = 'uploads/';\n$allowedExtensions = array('jpg', 'jpeg', 'png', 'gif');\n\n// Check if the request is a POST request\nif ($_SERVER['REQUEST_METHOD'] === 'POST') {\n    // Check if a file was uploaded\n    if (isset($_FILES['image'])) {\n        $image = $_FILES['image'];\n        $extension = strtolower(pathinfo($image['name'], PATHINFO_EXTENSION));\n\n        // Validate the file extension\n        if (in_array($extension, $allowedExtensions)) {\n            // Validate the file type\n            if (getimagesize($image['tmp_name']) !== false) {\n                // Move the uploaded file to the upload directory\n                $uploadPath = $uploadDir . uniqid() . '.' . $extension;\n                if (move_uploaded_file($image['tmp_name'], $uploadPath)) {\n                    // Image uploaded successfully\n                    echo 'Image uploaded successfully!';\n                } else {\n                    // Error moving the uploaded file\n                    echo 'Error moving the uploaded file.';\n                }\n            } else {\n                // Invalid file type\n                echo 'Invalid file type.';\n            }\n        } else {\n            // Invalid file extension\n            echo 'Invalid file extension.';\n        }\n    } else {\n        // No file was uploaded\n        echo 'No file was uploaded.';\n    }\n} else {\n    // Not a POST request\n    echo 'Not a POST request.';\n}