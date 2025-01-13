SELECT a.table_name, a.constraint_name, a.status\nFROM all_constraints a\nJOIN all_cons_columns b ON a.constraint_name = b.constraint_name\nWHERE a.constraint_type = 'R'\nAND a.r_constraint_name IN (\n  SELECT constraint_name\n  FROM all_constraints\n  WHERE table_name = 'FOO'\n  AND constraint_type IN ('P', 'U')\n);