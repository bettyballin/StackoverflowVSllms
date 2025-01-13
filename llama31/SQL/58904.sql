UPDATE\n  TABLE1 update_tbl\nSET\n  update_tbl.COL1 = 'VALUE'\nWHERE\n  EXISTS (\n    SELECT\n      1\n    FROM\n      TABLE1 a\n      TABLE2 b\n    WHERE\n      a.FK = b.PK\n      AND b.COL2 IN ('SET OF VALUES')\n      AND update_tbl.PK = a.PK\n  );