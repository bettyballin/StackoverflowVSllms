SELECT Ident2\nFROM yourTable\nWHERE MapId = SUBSTRING(@concatenatedValue, 1, CHARINDEX('|', @concatenatedValue) - 1)\n  AND Ident1 = SUBSTRING(@concatenatedValue, CHARINDEX('|', @concatenatedValue) + 1, LEN(@concatenatedValue))