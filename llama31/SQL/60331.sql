SELECT \n  m.id, m.title, m.sentAt, u.username\nFROM \n  message m\n  LEFT JOIN read_messages r ON m.id = r.message_id AND r.user_id = @userId\n  JOIN user u ON u.id = @userId\nWHERE \n  r.message_id IS NULL;