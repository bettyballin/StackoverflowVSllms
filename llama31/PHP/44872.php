$host = 'your_host';\n$user = 'your_user';\n$password = 'your_password';\n$database = 'your_database';\n$table = 'your_table';\n$rowsPerInsert = 100;\n\n$mysqli = new mysqli($host, $user, $password, $database);\nif ($mysqli->connect_errno) {\n    echo "Failed to connect to MySQL: (" . $mysqli->connect_errno . ") " . $mysqli->connect_error;\n    exit();\n}\n\n$result = $mysqli->query("SELECT * FROM $table");\nif (!$result) {\n    echo "Failed to retrieve data: (" . $mysqli->errno . ") " . $mysqli->error;\n    exit();\n}\n\n$dump = '';\nwhile ($row = $result->fetch_assoc()) {\n    $dump .= "(" . implode(',', array_map(function($value) {\n        return "'" . $mysqli->real_escape_string($value) . "'";\n    }, $row)) . "),\n";\n    if ($result->num_rows % $rowsPerInsert == 0) {\n        $dump = rtrim($dump, ",\n") . ";\nINSERT INTO $table VALUES\n";\n    }\n}\n$dump = rtrim($dump, ",\n") . ";";\n\nfile_put_contents('dump.sql', $dump);