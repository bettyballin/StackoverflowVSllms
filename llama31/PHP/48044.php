$mysqli = new mysqli($host, $username, $password);\n\nif ($mysqli->connect_errno) {\n    // handle connection error\n}\n\n$result = $mysqli->query("SHOW PRIVILEGES");\n$privileges = $result->fetch_all(MYSQLI_ASSOC);\n\n$createDatabasePrivilege = false;\nforeach ($privileges as $privilege) {\n    if ($privilege['Privilege'] === 'Create' && $privilege['Context'] === 'Databases') {\n        $createDatabasePrivilege = true;\n        break;\n    }\n}\n\nif ($createDatabasePrivilege) {\n    // user has create database privilege\n} else {\n    // hide "Create database" button from UI\n}