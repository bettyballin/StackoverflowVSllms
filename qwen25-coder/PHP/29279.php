if (array_key_exists('update', $_POST)) {\n    // Start transaction\n    if ($conn->begin_transaction()) {\n        try {\n            // Prepare and execute first statement for photos table\n            $sql1 = 'UPDATE photos SET photo_title = ? WHERE photo_id = ?';\n            $stmt1 = $conn->prepare($sql1);\n            $stmt1->bind_param('si', $_POST['photo_title'], $_POST['photo_id']);\n            if (!$stmt1->execute()) {\n                throw new Exception("Error updating photos table: " . $stmt1->error);\n            }\n\n            // Prepare and execute second statement for photographers table\n            $sql2 = 'UPDATE photographers SET photographer_name = ? WHERE photographer_id = (SELECT photographer_id FROM photos WHERE photo_id = ?)';\n            $stmt2 = $conn->prepare($sql2);\n            $stmt2->bind_param('si', $_POST['photographer_name'], $_POST['photo_id']);\n            if (!$stmt2->execute()) {\n                throw new Exception("Error updating photographers table: " . $stmt2->error);\n            }\n\n            // Commit transaction\n            $conn->commit();\n        } catch (Exception $e) {\n            // Rollback transaction on error\n            $conn->rollback();\n            echo 'Transaction failed: ' . $e->getMessage();\n        }\n    }\n}