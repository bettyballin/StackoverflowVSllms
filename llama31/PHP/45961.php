// Assuming you have a database connection established\n\n// Fetch unread posts and forums\n$unread_posts = $db->query("SELECT post_id, post_parent_forum \n                            FROM posts \n                            WHERE post_date > '$last_visit_date' \n                            AND post_id NOT IN (SELECT post_id FROM read_posts WHERE user_id = '$user_id')");\n\n// Store the unread posts in an array\n$unread_posts_array = array();\nwhile ($row = $unread_posts->fetch_assoc()) {\n    $unread_posts_array[$row['post_id']] = $row['post_parent_forum'];\n}\n\n// Store the array in the SESSION variable\n$_SESSION['unread_posts'] = $unread_posts_array;\n\n// To mark a post as read, simply remove it from the array\nunset($_SESSION['unread_posts'][$post_id]);