SELECT \n  sid, \n  sql_id, \n  sql_text, \n  cursor_id\nFROM \n  v$open_cursor;