SELECT 1 \nFROM dual \nWHERE EXISTS (\n  SELECT 1 \n  FROM x \n  WHERE x.col_a = value_a \n    AND x.col_b = value_b\n);