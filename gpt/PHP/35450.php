$connection = new PDO('mysql:host=hostname;dbname=database', 'username', 'password');\n\nfunction performQuery($connection) {\n    // Your query logic here\n    $statement = $connection->prepare("SELECT * FROM table");\n    $statement->execute();\n    return $statement->fetchAll(PDO::FETCH_ASSOC);\n}\n\n$result = performQuery($connection);