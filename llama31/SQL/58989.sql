SELECT id, name, rank() OVER (ORDER BY name) AS row_rank\nFROM table\nWHERE id = 47;