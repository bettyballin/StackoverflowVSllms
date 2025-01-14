try {\n    $pdo = new PDO('mysql:host=localhost;dbname=your_database', 'username', 'password');\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    $Date = date("Y-m-d");\n    $stmt = $pdo->prepare("SELECT * FROM service WHERE SType = :SType AND STR_TO_DATE(Start_date, '%m/%d/%Y') > :Date");\n    $stmt->execute([':SType' => 'Retreat', ':Date' => $Date]);\n\n    while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {\n        echo "ID: " . $row['id'] . ", Start Date: " . $row['Start_date'] . "<br>";\n    }\n} catch (PDOException $e) {\n    echo "Database error: " . $e->getMessage();\n}