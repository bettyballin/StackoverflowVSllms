try {\n    // Create a new PDO connection\n    $pdo = new PDO("mysql:host=hostname;dbname=database", "username", "password");\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    // Prepare statement\n    $stmt = $pdo->prepare("INSERT INTO `table` (`column`) VALUES (:value)");\n\n    // Bind parameters and execute\n    $stmt->bindParam(':value', $unsafe_variable);\n    $unsafe_variable = $_POST['user_input'];\n    \n    if ($stmt->execute()) {\n        echo "New record created successfully";\n    } else {\n        echo "Error: Could not execute statement.";\n    }\n} catch(PDOException $e) {\n    echo "Connection failed: " . $e->getMessage();\n}\n\n// No need to explicitly close the PDO connection as it will be closed when the script ends