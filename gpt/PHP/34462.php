$conn->autocommit(FALSE); // Turn off auto-commit\n\ntry {\n    // Execute all the insert operations here\n    // ...\n\n    $conn->commit(); // Commit the transaction if all inserts are successful\n} catch (Exception $e) {\n    $conn->rollback(); // Roll back the transaction if any insert fails\n    echo "Failed: " . $e->getMessage();\n}\n\n$conn->autocommit(TRUE); // Turn on auto-commit