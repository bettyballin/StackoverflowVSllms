$result = mysql_query($query, $conn);\nif (!$result) {\n    die("A MySQL error has occurred.<br />Your Query: " . $query . "<br /> Error: (" . mysql_errno() . ") " . mysql_error());\n}\necho "You have been entered into our Database!";