$stmt = $pdo->prepare("SELECT *\n                       FROM `myTable`\n                       WHERE `id` = :id");\n$stmt->bindParam(":id", 4);\n$stmt->execute();