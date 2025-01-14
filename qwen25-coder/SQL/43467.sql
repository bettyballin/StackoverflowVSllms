-- Original query with outer joins and filter in WHERE clause\nSELECT * FROM A \nLEFT JOIN B ON A.pk = B.fk\nFULL OUTER JOIN G ON A.pk = G.fk\nWHERE A.pk = B.fk AND A.pk = G.fk;\n\n-- This can be reduced to a series of inner joins due to the WHERE conditions\nSELECT * FROM A \nINNER JOIN B ON A.pk = B.fk\nINNER JOIN G ON A.pk = G.fk;