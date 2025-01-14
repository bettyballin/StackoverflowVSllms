try {\n    $pdo = new PDO('pgsql:host=your_host;dbname=your_dbname', 'username', 'password');\n    // Set the PDO error mode to exception\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    $stmt = $pdo->prepare("UPDATE A SET type = :type WHERE id = :id");\n    $stmt->bindParam(':type', $strType);\n    $stmt->bindParam(':id', $ID, PDO::PARAM_INT);\n\n    $stmt->execute();\n} catch(PDOException $e) {\n    echo "Error: " . $e->getMessage();\n}