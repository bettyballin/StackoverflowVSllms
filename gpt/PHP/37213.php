$filesQuery = "SELECT FILENAME FROM FILES WHERE ARTICLE_NO = ?";\n\nif ($getFiles = $con->prepare($filesQuery)) {\n    $getFiles->bind_param("i", $pk); // Use "i" for integer\n    $getFiles->execute();\n    $getFiles->bind_result($FILENAME);\n    $files = array();\n\n    while ($getFiles->fetch()) {\n        $files[] = array('FILENAME' => $FILENAME);\n    }\n    $getFiles->close();\n}\n\nforeach ($files as $file) {\n    echo '<p><a href="./files/'. $file['FILENAME'] .'">'. $file['FILENAME'] .'</a></p>' . "\n";\n}