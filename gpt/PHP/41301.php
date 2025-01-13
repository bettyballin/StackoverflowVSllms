<?php\n$theArrayValue = '9,admin@domain.com,1,9,gg@domain.com,2,2,pra@domain.com,3,2,sh@sh.com,4';\n\n// Step 1: Split the string by commas\n$elements = explode(',', $theArrayValue);\n\n// Step 2: Filter out the numeric elements (assuming user IDs are numeric)\n$userIds = array_filter($elements, 'is_numeric');\n\n// Step 3: Prepare a placeholder string for the query\n$placeholders = implode(',', array_fill(0, count($userIds), '?'));\n\n// Step 4: Construct the SQL query to delete the records\n$sql = "DELETE FROM users WHERE id IN ($placeholders)";\n\n// Step 5: Execute the query securely using prepared statements\ntry {\n    $pdo = new PDO('mysql:host=localhost;dbname=your_database', 'username', 'password');\n    $stmt = $pdo->prepare($sql);\n    $stmt->execute($userIds);\n    echo "Records deleted successfully.";\n} catch (PDOException $e) {\n    echo "Error: " . $e->getMessage();\n}\n?>