// Check if the file input is empty\nif (empty($_FILES['image']['name'])) {\n    // If no new file is uploaded, retain the existing image caption\n    $image_caption = $row['image_caption'];\n} else {\n    // Handle the file upload\n    $image = str_replace(' ', '_', $_FILES['image']['name']);\n    // Move the uploaded file to the designated directory\n    move_uploaded_file($_FILES['image']['tmp_name'], UPLOAD_DIR . $image);\n    // Update the image caption with the new filename\n    $image_caption = $image;\n}\n\n// Assume you have a database connection and prepared statements set up\n// Example SQL update statement:\n$sql = "UPDATE clients SET image_caption = ? WHERE cliente_id = ?";\n$stmt = $pdo->prepare($sql);\n$stmt->execute([$image_caption, $_POST['cliente_id']]);