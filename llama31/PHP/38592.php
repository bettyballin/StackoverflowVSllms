$stmt = $mysqli->prepare("INSERT INTO ilike (ilike_user_id, ilike_object_id, ilike_author_user_id) VALUES (?, ?, ?)");\n$stmt->bind_param("iii", $_POST['user_id'], $_POST['ob_id'], $_POST['author_user_id']);\n$stmt->execute();