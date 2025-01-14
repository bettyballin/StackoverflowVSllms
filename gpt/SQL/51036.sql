WITH RECURSIVE CommentTree AS (\n    SELECT\n        comment_id,\n        article_id,\n        user_id,\n        comment,\n        timestamp,\n        parent_comment_id,\n        0 AS level\n    FROM comments\n    WHERE article_id = 1 AND parent_comment_id IS NULL\n\n    UNION ALL\n\n    SELECT\n        c.comment_id,\n        c.article_id,\n        c.user_id,\n        c.comment,\n        c.timestamp,\n        c.parent_comment_id,\n        ct.level + 1\n    FROM comments c\n    INNER JOIN CommentTree ct ON ct.comment_id = c.parent_comment_id\n)\nSELECT\n    comment_id,\n    article_id,\n    user_id,\n    comment,\n    timestamp,\n    parent_comment_id,\n    level\nFROM CommentTree\nORDER BY level, timestamp;