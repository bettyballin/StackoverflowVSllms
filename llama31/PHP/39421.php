$query = "SELECT * FROM table WHERE thing = 'whatever'";\n$result = mysqli_query($db, $query);\n\nif ($row = mysqli_fetch_array($result)) {\n    do {\n        echo "<p>$row[whatever]</p>";\n    } while ($row = mysqli_fetch_array($result));\n} else {\n    echo "<p>No results found</p>";\n}