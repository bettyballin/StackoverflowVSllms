SELECT f.forum_title, f.forum_id, p.post_subject, p.post_user, p.post_id, p.post_date \nFROM board_forums f\nLEFT JOIN (\n    SELECT post_parentforum, MAX(post_id) AS latest_post_id\n    FROM board_posts\n    GROUP BY post_parentforum\n) latest_posts ON f.forum_id = latest_posts.post_parentforum\nLEFT JOIN board_posts p ON latest_posts.latest_post_id = p.post_id\nWHERE f.forum_status = 1\nORDER BY f.forum_position;