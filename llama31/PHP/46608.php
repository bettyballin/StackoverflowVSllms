$result = $mysqli->query($query);\n$count = $result->fetch_assoc()['count'];\nif ($count > 0) {\n    // entry exists\n}