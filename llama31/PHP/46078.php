// Reply endpoint\nif ($_SERVER['REQUEST_METHOD'] == 'POST' && $_POST['comment_id'] && $_POST['reply']) {\n  $commentId = $_POST['comment_id'];\n  $replyText = $_POST['reply'];\n  // Save reply to database with comment ID\n  // ...\n  // Return the new reply HTML\n  echo '<div class="reply">' . $replyText . '</div>';\n}