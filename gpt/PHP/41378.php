$username = $mysqli->real_escape_string($_POST['username']);\n$query = "SELECT * FROM users WHERE username = '$username'";