SELECT 'user' AS type, id, name \nFROM users \nWHERE name LIKE '%search_text%'\n\nUNION ALL\n\nSELECT 'group' AS type, id, name \nFROM groups \nWHERE name LIKE '%search_text%';