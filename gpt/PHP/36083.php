$array = [1, 2, 3, 4];\n$listOfIds = implode(',', $array);\n\n// Assuming $pdo is your PDO connection\n$statement = $pdo->prepare("CALL your_stored_procedure(:listOfIds)");\n$statement->bindParam(':listOfIds', $listOfIds);\n$statement->execute();