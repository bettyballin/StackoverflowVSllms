if (isset($_FILES['song']) && $_FILES['song']['error'] == UPLOAD_ERR_OK) {\n    $uploadDir = '/path/to/your/upload/directory/';\n    $uploadFile = $uploadDir . basename($_FILES['song']['name']);\n    \n    if (move_uploaded_file($_FILES['song']['tmp_name'], $uploadFile)) {\n        echo "File is valid, and was successfully uploaded.\n";\n    } else {\n        echo "Possible file upload attack!\n";\n    }\n} else {\n    echo "No song uploaded or there was an error.\n";\n}