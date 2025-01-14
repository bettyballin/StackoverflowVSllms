$sql = 'UPDATE photos \n        SET photo_title = ? \n        WHERE photo_id = ?';\n\n// Prepare the statement\n$stmt = $conn->prepare($sql);\n$stmt->bind_param("si", $_POST['photo_title'], 3); // Assuming $conn is your database connection\n$stmt->execute();\n\nif (!empty($_POST['type_name'])) {\n    $sqlTypeUpdate = 'UPDATE types \n                      SET type_name = ? \n                      WHERE type_id = (SELECT type_id FROM photos WHERE photo_id = ?)';\n\n    // Prepare the statement for updating types\n    $stmtTypeUpdate = $conn->prepare($sqlTypeUpdate);\n    $stmtTypeUpdate->bind_param("si", $_POST['type_name'], 3); // Assuming you want to update the type of the photo with id 3\n    $stmtTypeUpdate->execute();\n}