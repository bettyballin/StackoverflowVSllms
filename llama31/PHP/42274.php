$query4 = mysqli_query($conn, "\n    SELECT * \n    FROM comments \n    INNER JOIN users ON comments.poster = users.id \n    WHERE comments.content_id = '$id' AND comments.content = 'thread' \n    ORDER BY comments.date ASC\n");\n\nwhile ($comment = mysqli_fetch_array($query4)) {\n    // process the comment\n}