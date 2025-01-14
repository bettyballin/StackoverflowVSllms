SELECT \n    t1.Column1, t1.Column2, t1.Column3, t1.Column4, t1.Column5, t1.Column6, t1.Column7, t1.Column8, t1.Column9, t1.Column10,\n    t3.ColumnA, t3.ColumnB, t3.ColumnC, t3.ColumnD, t3.ColumnE\nFROM \n    Table1 AS t1\nINNER JOIN \n    Table2 AS t2 ON t1.ID = t2.T1ID\nINNER JOIN \n    Table3 AS t3 ON t2.T3ID = t3.PK