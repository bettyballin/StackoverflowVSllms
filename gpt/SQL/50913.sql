INSERT INTO comments (article_id, user_id, comment, parent_comment_id) VALUES\n(1, 1, 'This is the first comment.', NULL),\n(1, 2, 'This is a reply to the first comment.', 1),\n(1, 3, 'This is another comment.', NULL),\n(1, 4, 'This is a reply to the second comment.', 2);