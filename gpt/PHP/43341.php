$sql = "\n    SELECT \n        table1.column1, \n        table2.column2, \n        table3.column3, \n        table4.column4\n    FROM \n        table1\n    JOIN \n        table2 ON table1.id = table2.table1_id\n    JOIN \n        table3 ON table1.id = table3.table1_id\n    JOIN \n        table4 ON table1.id = table4.table1_id\n    WHERE \n        table1.id = :id\n";\n$stmt = $pdo->prepare($sql);\n$stmt->execute(['id' => $id]);\n$result = $stmt->fetch(PDO::FETCH_ASSOC);