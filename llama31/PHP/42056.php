$stmt = $mysqli->prepare('INSERT INTO `table` (`column`) VALUES (?)');\n$stmt->bind_param('s', $_POST['user_input']);\n$stmt->execute();