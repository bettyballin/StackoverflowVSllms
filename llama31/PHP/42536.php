if (empty($_FILES['image']['name'])) {\n    $image_caption = $_POST['image_path'];\n} else {\n    $image = str_replace(' ', '_', $_FILES['image']['name']);\n    move_uploaded_file($_FILES['image']['tmp_name'], UPLOAD_DIR . $image);\n    $image_caption = $image;\n}