if (is_uploaded_file($_FILES['picture1']['tmp_name'])) {\n    $full_file_path = 'path/to/destination/' . basename($_FILES['picture1']['name']);\n    if (move_uploaded_file($_FILES['picture1']['tmp_name'], $full_file_path)) {\n        echo "File is valid, and was successfully uploaded.\n";\n    } else {\n        echo "Possible file upload attack!\n";\n    }\n} else {\n    echo "File upload not successful.\n";\n}