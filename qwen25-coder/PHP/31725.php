$query = "SELECT * FROM messages WHERE recipient = $userID AND `read` = 0";\n$result = mysql_query($query);\n\nif (!$result) {\n    die('Invalid query: ' . mysql_error());\n}\n\n$msgs = mysql_num_rows($result);\necho $msgs;