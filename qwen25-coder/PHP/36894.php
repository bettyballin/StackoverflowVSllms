<?php\n// Define the target directory for uploaded files\n$targetDirectory = __DIR__ . '/uploads';\n$targetFile = $targetDirectory . basename($_FILES["fileToUpload"]["name"]);\n\n// Check if the file already exists\nif (file_exists($targetFile)) {\n    die("Sorry, file already exists.");\n}\n\n// Check file size\nif ($_FILES["fileToUpload"]["size"] > 500000) { // 500KB\n    die("Sorry, your file is too large.");\n}\n\n// Allow certain file formats\n$imageFileType = strtolower(pathinfo($targetFile, PATHINFO_EXTENSION));\n$allowedTypes = array('jpg', 'jpeg', 'png', 'gif');\nif (!in_array($imageFileType, $allowedTypes)) {\n    die("Sorry, only JPG, JPEG, PNG & GIF files are allowed.");\n}\n\n// Try to move the uploaded file\nif (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $targetFile)) {\n    echo "The file ". htmlspecialchars(basename($_FILES["fileToUpload"]["name"])). " has been uploaded.";\n} else {\n    die("Sorry, there was an error uploading your file.");\n}\n?>