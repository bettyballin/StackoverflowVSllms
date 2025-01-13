if (array_key_exists('update', $_POST)) {\n    // First UPDATE statement for the 'photos' table\n    $sql1 = 'UPDATE photos SET photo_title = ? WHERE photo_id = ?';\n    $stmt1 = $conn->stmt_init();\n    if ($stmt1->prepare($sql1)) {\n        $stmt1->bind_param('si', $_POST['photo_title'], $_POST['photo_id']);\n        $done1 = $stmt1->execute();\n    }\n\n    // Second UPDATE statement for the 'photographers' table\n    $sql2 = 'UPDATE photographers SET photographer_name = ? WHERE photographer_id = (SELECT photographer_id FROM photos WHERE photo_id = ?)';\n    $stmt2 = $conn->stmt_init();\n    if ($stmt2->prepare($sql2)) {\n        $stmt2->bind_param('si', $_POST['photographer_name'], $_POST['photo_id']);\n        $done2 = $stmt2->execute();\n    }\n\n    // Check if both updates were successful\n    if ($done1 && $done2) {\n        echo "Records updated successfully.";\n    } else {\n        echo "Error updating records.";\n    }\n}