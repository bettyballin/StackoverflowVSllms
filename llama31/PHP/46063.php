// upload.php\n$upload_folder = '/path/to/uploaded/files/'; // set your upload folder\n\nif (isset($_FILES['file'])) {\n    $file_name = basename($_FILES['file']['name']);\n    $upload_path = $upload_folder . $file_name;\n\n    if (move_uploaded_file($_FILES['file']['tmp_name'], $upload_path)) {\n        echo 'File uploaded successfully!';\n    } else {\n        echo 'Error uploading file!';\n    }\n}