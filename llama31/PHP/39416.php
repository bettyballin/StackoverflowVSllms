$db_path = $_SERVER['DOCUMENT_ROOT'] . '\WebUpdate\\' . $file_name . '.mdb';\n\n$dsn = "odbc:DRIVER={Microsoft Access Driver (*.mdb)};DBQ=$db_path";\ntry {\n    $db = new PDO($dsn);\n} catch (PDOException $e) {\n    echo 'Connection failed: ' . $e->getMessage();\n    exit();\n}