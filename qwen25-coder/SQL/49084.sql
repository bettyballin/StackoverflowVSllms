CREATE TABLE people (\n     id       INTEGER PRIMARY KEY,\n     name     VARCHAR(100),\n     active   BOOLEAN,\n     ...\n   ) PARTITION BY LIST (active) (\n     PARTITION p_active VALUES IN (true),\n     PARTITION p_inactive VALUES IN (false)\n   );