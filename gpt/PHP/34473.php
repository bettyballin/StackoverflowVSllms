try {\n    $conn = new PDO($DB, $USER, $PASSWORD);\n    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    // Start transaction\n    $conn->beginTransaction();\n\n    try {\n        $conn->exec("DELETE FROM MY_TABLE");\n        // Commit the transaction\n        $conn->commit();\n        echo "done";\n    } catch (Exception $e) {\n        // Rollback the transaction if something failed\n        $conn->rollBack();\n        echo "Failed: " . $e->getMessage();\n    }\n} catch (PDOException $e) {\n    echo "Connection failed: " . $e->getMessage();\n}