$genre = array(\n    'Action',\n    'Adventure',\n    'Fantasy'\n);\n\n$selectGenre_sql = 'SELECT genreID FROM genres WHERE dbGenre = ?';\n$array1 = array();\n\nif ($stmt = $mysqli->prepare($selectGenre_sql)) {\n    $stmt->bind_param('s', $dbGenre);\n    $stmt->bind_result($genreID);\n\n    foreach ($genre as $dbGenre) {\n        $stmt->execute();\n        while ($stmt->fetch()) {\n            $array1[] = $genreID;\n        }\n    }\n    $stmt->close();\n}\n\nprint_r($array1);