SELECT s.something\nFROM someTable s\nLEFT JOIN tmpIdTable t ON s.idcode = t.ids\nWHERE t.ids IS NULL;