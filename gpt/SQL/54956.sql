SELECT *\nFROM users\nWHERE TIMESTAMPDIFF(MINUTE, last_login, NOW()) <= 10;