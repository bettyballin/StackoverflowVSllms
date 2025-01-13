$sql = 'SELECT f.*, p.post_id, p.topic_id, p.forum_id, p.post_time, p.post_username, u.user_id, u.username, u.user_colour\n    FROM ' . FORUMS_TABLE . ' f\n    LEFT JOIN ' . POSTS_TABLE . ' p ON (f.forum_id = p.forum_id AND p.post_approved = 1)\n    LEFT JOIN ' . USERS_TABLE . ' u ON (p.post_username = u.username)\n    ORDER BY f.left_id ASC';