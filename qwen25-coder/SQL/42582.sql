SELECT CAST(BigMacs AS INT) AS BigMacsInt\nFROM McTable\nWHERE BigMacs NOT LIKE '%[^0-9]%' AND CAST(BigMacs AS INT) > 6;