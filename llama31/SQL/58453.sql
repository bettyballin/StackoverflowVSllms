DELETE t1\nFROM table1 AS t1\nINNER JOIN table2 AS t2 ON t1.column = t2.column\nINNER JOIN table3 AS t3 ON t2.column = t3.column\nWHERE condition;