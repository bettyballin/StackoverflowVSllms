// assuming you're using mysqli extension\n$mysqli = new mysqli("localhost", "username", "password", "database");\n\n// delete comments before deleting the post\n$mysqli->query("DELETE FROM Comments WHERE PostID = '$post_id'");\n\n// delete the post\n$mysqli->query("DELETE FROM Posts WHERE PostID = '$post_id'");