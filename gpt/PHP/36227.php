$query = 'SELECT CALC_IT(`Flag`, `One`, `Two`) FROM `mydb`.`table` WHERE `Condition` = 1';\n$db = new PDO('mysql:host=localhost;dbname=mydb', 'user', 'pass');\n$stmt = $db->prepare($query);\nif (!$stmt->execute()) {\n    var_dump($stmt->errorInfo());\n}