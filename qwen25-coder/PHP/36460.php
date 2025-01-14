try {\n    $conn = new PDO($DB, $USER, $PASSWORD);\n    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    // Begin transaction\n    $conn->beginTransaction();\n    \n    try {\n        $sql = "DELETE FROM MY_TABLE";\n        $stmt = $conn->prepare($sql);\n        $stmt->execute();\n\n        echo "Records deleted successfully.";\n        \n        // Commit the changes\n        $conn->commit();\n    } catch (PDOException $e) {\n        // Rollback transaction on error\n        $conn->rollback();\n        throw new Exception("Database error: " . $e->getMessage());\n    }\n} catch (Exception $e) {\n    echo "Error: " . $e->getMessage();\n}