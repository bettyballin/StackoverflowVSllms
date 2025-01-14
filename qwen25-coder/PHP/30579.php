try {\n    $pdo = new PDO('mysql:host=your_host;dbname=your_db', 'username', 'password');\n    // set the PDO error mode to exception\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    // prepare statement with placeholders for each id\n    $placeholders = implode(',', array_fill(0, count($id_array), '?'));\n    $stmt = $pdo->prepare("SELECT * FROM myTbl WHERE category_id IN ($placeholders)");\n\n    // execute statement with the actual ids as parameters\n    $stmt->execute($id_array);\n\n    // fetch results\n    $results = $stmt->fetchAll();\n    \n    // do something with results\n} catch(PDOException $e) {\n    echo "Error: " . $e->getMessage();\n}