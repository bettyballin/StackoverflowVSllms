try {\n    $connectionString = "sqlsrv:Server=" . $mssql_server .\n                        ";Database=" . $mssql_db .\n                        ";CharacterSet=UTF-8";\n    $dbh = new PDO($connectionString, $mssql_login, $mssql_pwd);\n} catch (PDOException $e) {\n    die("Connection failed: " . $e->getMessage());\n}