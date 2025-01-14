<?php\n$pdo = new PDO('mysql:host=localhost;dbname=test', 'user', 'pass');\n\n$query = '\nSELECT rank\nFROM (\n  SELECT \n    id, \n    name,\n    @rank:=@rank + 1 AS rank\n  FROM \n    people, (SELECT @rank:=0) r\n  ORDER BY \n    name ASC\n) ranked_people\nWHERE id = :id;';\n\n$stmt = $pdo->prepare($query);\n$stmt->execute(['id' => 1]); // Change to 'name' and 'Steve' if needed\n\n$result = $stmt->fetch(PDO::FETCH_ASSOC);\nif ($result) {\n    echo "Rank: " . $result['rank'];\n} else {\n    echo "Row not found.";\n}\n?>