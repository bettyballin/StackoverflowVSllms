$query = "SELECT * FROM `table`";\n$results = mysqli_query($connection, $query);\n\nif ($results === FALSE) {\n    die(mysqli_error($connection)); // handle error\n} elseif (mysqli_num_rows($results) > 0) {\n    echo "Rows returned.";\n} else {\n    echo "No rows returned.";\n}