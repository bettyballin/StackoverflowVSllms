$stmt = $dbh->prepare("INSERT INTO place (name) VALUES (?)");\n$stmt->bind_param("s", $name);\n$stmt->execute();