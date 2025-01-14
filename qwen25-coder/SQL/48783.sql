WITH RECURSIVE series AS (\n    SELECT 0 AS x\n    UNION ALL\n    SELECT x + 1 FROM series WHERE x < 23 -- Adjust this range as needed\n),\nsine_curve AS (\n    SELECT \n        x,\n        11.5 * (SIN(2 * pi() * x / 24) + 1) AS y\n    FROM series\n)\nSELECT x, round(y) AS sine_value\nFROM sine_curve\nORDER BY x;