$genre = array(\n    'Action',\n    'Adventure',\n    'Fantasy'\n);\n$selectGenre_sql = 'SELECT genreID FROM genres WHERE dbGenre = ?';\n\n$array1 = array();\n\nif ($stmt = $mysqli->prepare($selectGenre_sql)) { // Assuming $mysqli is your mysqli connection\n    foreach ($genre as $g) {\n        $stmt->bind_param('s', $g);\n        $stmt->execute();\n        $stmt->bind_result($genreID);\n        while ($stmt->fetch()) {\n            $array1[] = $genreID;\n        }\n    }\n    $stmt->close();\n}\n\n// Output the results\nprint_r($array1);