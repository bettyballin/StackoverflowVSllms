$threads = mysqli_query($conn, "SELECT t.id, t.title FROM threads t JOIN comments c ON t.id = c.thread_id ORDER BY c.date DESC");\n\nwhile ($thread = mysqli_fetch_assoc($threads)) {\n    echo $thread['title'];\n}