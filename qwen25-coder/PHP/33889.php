function generateUniqueFilename() {\n    $timestamp = date('U');\n    $randomComponent = bin2hex(random_bytes(16)); // Generate a random component\n    return md5($timestamp . $randomComponent);\n}\n\n$filename = generateUniqueFilename();\n\n// Use the same $filename throughout your script for all operations involving this file\n$thumb = 'thumbs/' . $filename . '_thumb.jpg';\n$full = 'uploads/' . $filename . '.jpg';\n\n// Later, insert into database\n$sql = "INSERT INTO uploads (thumbnail_filename, fullsize_filename) VALUES (?, ?)";\n$stmt = mysqli_prepare($connection, $sql);\nmysqli_stmt_bind_param($stmt, "ss", $thumb, $full);\nmysqli_stmt_execute($stmt);