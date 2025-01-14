$retreiveQuery = 'SELECT username, firstname, lastname FROM USERS WHERE username = ?';\n\nif ($getRecords = $con->prepare($retreiveQuery)) {\n    $getRecords->bind_param("s", $username);\n    $getRecords->execute();        \n    $getRecords->bind_result($username, $firstname, $lastname);\n    \n    while ($getRecords->fetch()) {\n        echo "<h1>".$username."</h1>";\n        echo "<p><strong>First Name: </strong>".$firstname."</p>";\n        echo "<p><strong>Surname: </strong>".$lastname."</p>";\n    }\n    \n    $getRecords->close();\n} else {\n    echo "Error: " . $con->error;\n}