<?php\n$ids = [1, 2, 3, 4];\n$listOfIds = implode(',', $ids);\n\n// Assuming $pdo is your PDO instance\n$stmt = $pdo->prepare("CALL my_stored_procedure(:list)");\n$stmt->execute([':list' => $listOfIds]);\n?>