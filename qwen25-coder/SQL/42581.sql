SELECT TRY_CAST(BigMacs AS INT) AS BigMacsInt\nFROM McTable\nWHERE BIGMACS IS NOT NULL \nAND TRY_CAST(BigMacs AS INT) > 6;