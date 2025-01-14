function createRSS() {\n    $currentDate = time();\n    $sql = "SELECT * FROM ". ADS_TABLE ." WHERE expires > ? ORDER BY enterd DESC LIMIT 0,400";\n    $conn = new mysqli(DB_HOST, DB_USER, DB_PASSWORD, DB_NAME);\n\n    if ($conn->connect_error) {\n        die("Connection failed: " . $conn->connect_error);\n    }\n\n    $stmt = $conn->prepare($sql);\n    $stmt->bind_param("i", $currentDate);\n    $stmt->execute();\n    $results = $stmt->get_result();\n\n    // Open a file pointer to an RSS file\n    $fp = fopen("mexautosrss.xml", "w");\n    if (!$fp) {\n        // Can't write to a file\n        return;\n    }\n\n    fwrite($fp, "<?xml version='1.0' encoding='iso-8859-1' ?>\n");\n    fwrite($fp, "<rss version='2.0'>\n");\n    fwrite($fp, "<channel>\n");\n    fwrite($fp, "<title>MexAutos.com</title>\n");\n    fwrite($fp, "<link>http://www.mexautos.com/</link>\n");\n    fwrite($fp, "<description>Anuncios de Autos y Camionetas Usados en Mexico.</description>\n");\n    fwrite($fp, "<language>es-mx</language>\n");\n    fwrite($fp, "<atom:link href='http://www.mexautos.com/mexautosrss.xml' rel='self' type='application/rss+xml' />\n");\n    fwrite($fp, "<image><url>http://www.mexautos.com/images/logo_top_es.gif</url><title>Mexautos.com</title><link>http://www.mexautos.com</link></image>\n");\n\n    while ($row = $results->fetch_assoc()) {\n        $makeId = $row['make'];\n        $makeSQL = "SELECT name FROM ". CAR_MAKES_TABLE ." WHERE pkMakeID=?";\n        $makeStmt = $conn->prepare($makeSQL);\n        $makeStmt->bind_param("i", $makeId);\n        $makeStmt->execute();\n        $makeResults = $makeStmt->get_result();\n        $make = $makeResults->fetch_row();\n\n        $modelId = $row['model'];\n        $modelSQL = "SELECT name FROM ". CAR_MODELS_TABLE ." WHERE pkModelID=?";\n        $modelStmt = $conn->prepare($modelSQL);\n        $modelStmt->bind_param("i", $modelId);\n        $modelStmt->execute();\n        $modelResults = $modelStmt->get_result();\n        $model = $modelResults->fetch_row();\n\n        $stateId = $row['state'];\n        $stateSQL = "SELECT name FROM ". STATES_TABLE ." WHERE pkStateID=?";\n        $stateStmt = $conn->prepare($stateSQL);\n        $stateStmt->bind_param("i", $stateId);\n        $stateStmt->execute();\n        $stateResults = $stateStmt->get_result();\n        $state = $stateResults->fetch_row();\n\n        $title = htmlspecialchars($make[0]." ".$row['make_other']." ".$model[0]." ".$row['model_other']." '".$row['model_year']);\n        $content = htmlspecialchars("$".$row['price']." mil pesos ".$row['color']." Clima: ".$row['clima']." ".$row['milage']." mil kms Puertas: ".$row['doors']." ".$row['transmission']." ".$row['comment']." Tel: ".$row['tel_num']." (".$state[0].")");\n\n        fwrite($fp, "<item>\n");\n        fwrite($fp, "<title>{$title}</title>\n");\n        fwrite($fp, "<description>{$content}</description>\n");\n        fwrite($fp, "</item>\n");\n    }\n\n    fwrite($fp, "</channel>\n");\n    fwrite($fp, "</rss>\n");\n\n    fclose($fp);\n\n    $stmt->close();\n    $conn->close();\n}