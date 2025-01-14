try {\n    // Create a new PDO instance to connect to SQLite\n    $pdo = new PDO('sqlite:/path/to/database.sqlite');\n    // Set error mode to exception\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    // Perform queries...\n\n} catch (PDOException $e) {\n    echo "Connection failed: " . $e->getMessage();\n} finally {\n    // Close the connection by destroying the instance\n    $pdo = null;\n}