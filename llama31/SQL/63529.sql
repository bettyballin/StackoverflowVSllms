SELECT unread_count\nFROM article_unread_comments\nWHERE article_id = ? AND user_id = ?;