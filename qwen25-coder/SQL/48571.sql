SELECT  user_id, session, MAX(page) AS max_page\nFROM    views\nWHERE   user_id = '1'\nGROUP BY\n        session\nORDER BY\n        max_page DESC;