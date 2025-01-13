SELECT\n    a.*,\n    CASE\n        WHEN a.reference_table = 'comments' THEN (\n            SELECT CONCAT(c.text, ' by ', u.username)\n            FROM comments c\n            JOIN users u ON c.author_id = u.id\n            WHERE c.id = a.reference_id\n        )\n        WHEN a.reference_table = 'page_updates' THEN (\n            SELECT CONCAT('Page updated: ', p.title)\n            FROM pages p\n            WHERE p.id = a.reference_id\n        )\n        WHEN a.reference_table = 'subscriptions' THEN (\n            SELECT CONCAT('Subscribed to: ', s.name)\n            FROM subscriptions s\n            WHERE s.id = a.reference_id\n        )\n        ELSE 'Unknown Activity'\n    END AS activity_details\nFROM\n    activities a\nWHERE\n    a.user_id = ?  -- Assuming there's a column to filter by user\nORDER BY\n    a.created_at DESC\nLIMIT 10;  -- Fetch the 10 most recent activities