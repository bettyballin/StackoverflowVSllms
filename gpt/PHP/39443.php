function book($memberid, $classid) {\n    $mysqli = new mysqli("your_host", "your_user", "your_password", "your_database");\n\n    // Start the transaction\n    $mysqli->begin_transaction();\n\n    try {\n        // Acquire a lock on the specific row\n        $query = "SELECT booked FROM classes WHERE member_id = ? AND class_id = ? FOR UPDATE";\n        $stmt = $mysqli->prepare($query);\n        $stmt->bind_param("ii", $memberid, $classid);\n        $stmt->execute();\n        $result = $stmt->get_result();\n        $row = $result->fetch_assoc();\n\n        if (!$row['booked']) {\n            // Update the db and change the booked variable to true\n            $updateQuery = "UPDATE classes SET booked = 1 WHERE member_id = ? AND class_id = ?";\n            $updateStmt = $mysqli->prepare($updateQuery);\n            $updateStmt->bind_param("ii", $memberid, $classid);\n            $updateStmt->execute();\n        }\n\n        // Commit the transaction\n        $mysqli->commit();\n    } catch (Exception $e) {\n        // An error occurred, rollback the transaction\n        $mysqli->rollback();\n        throw $e;\n    } finally {\n        // Close the statement and the connection\n        $stmt->close();\n        $updateStmt->close();\n        $mysqli->close();\n    }\n}