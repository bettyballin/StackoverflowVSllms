$mysqli = new mysqli('hostname', 'username', 'password', 'database', 3306, MYSQLI_CLIENT_COMPRESS);\n\nif ($mysqli->connect_error) {\n    die('Connect Error (' . $mysqli->connect_errno . ') ' . $mysqli->connect_error);\n}\n\n// Your code to interact with the database