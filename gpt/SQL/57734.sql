SELECT a.refnum, b.refnum, c.refnum\nFROM myTable a\nLEFT OUTER JOIN myTable b ON a.contid = b.contid AND b.type = 10000\nLEFT OUTER JOIN myTable c ON a.contid = c.contid AND c.type = 20000\nWHERE a.type = 90000;