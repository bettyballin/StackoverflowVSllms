if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_FILES['company_logo'])) {\n    $uploadDirectory = 'tmp_images/';\n    $tempFilePath = $uploadDirectory . basename($_FILES['company_logo']['name']);\n\n    if (move_uploaded_file($_FILES['company_logo']['tmp_name'], $tempFilePath)) {\n        // Store the temporary file path in the session\n        session_start();\n        $_SESSION['temp_image_path'] = $tempFilePath;\n    } else {\n        echo "Failed to upload image.";\n    }\n}