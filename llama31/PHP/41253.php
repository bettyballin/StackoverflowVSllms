$query = "SELECT val FROM table WHERE id = 1";\n$result = mysqli_query($link, $query);\n$value = mysqli_fetch_scalar($result); // returns the first column of the first row