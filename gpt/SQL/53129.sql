SELECT DISTINCT u.userid, u.username\nFROM User u\nLEFT JOIN Key k ON u.userid = k.userid\nLEFT JOIN Laptop l ON u.userid = l.userid\nWHERE k.keyid IS NOT NULL OR l.laptopid IS NOT NULL;