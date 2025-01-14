<?php\n\n$threadID = intval($_GET['threadID']);\n$link = mysqli_connect("localhost", "my_user", "my_password", "my_db");\n\nif (!$link) {\n    die('Connect Error (' . mysqli_connect_errno() . ') ' . mysqli_connect_error());\n}\n\n$query = "SELECT accounts.title \n          FROM threads \n          INNER JOIN accounts \n          ON threads.author = accounts.id \n          WHERE threads.id = ?";\n\n$stmt = $link->prepare($query);\n$stmt->bind_param("i", $threadID);\n$stmt->execute();\n$result = $stmt->get_result();\n\nif ($row = $result->fetch_assoc()) {\n    $title = $row['title'];\n}\n\nmysqli_close($link);\n\n?>