try {\n    // Prepare the SQL statement\n    $stmt = $pdo->prepare('SELECT * FROM dacc_data WHERE date >= :start_date AND date <= :end_date');\n\n    // Bind parameters to the statement\n    $stmt->bindParam(':start_date', $_GET['start_date']);\n    $stmt->bindParam(':end_date', $_GET['end_date']);\n\n    // Execute the statement\n    $stmt->execute();\n\n    // Fetch and display results\n    while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {\n        print_r($row);\n    }\n} catch (PDOException $e) {\n    die('Could not execute query: ' . $e->getMessage());\n}