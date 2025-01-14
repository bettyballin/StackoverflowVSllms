SELECT \n    CAST(table2.foo_1 AS DATETIME) AS date,\n    table1.foo_0, table1.bar1, table2.foo_2, foo_3, foo_4, foo_5,\n    foo_6, foo_7, foo_8, foo_9, foo_10, foo_11, foo_12, foo_13, \n    foo_14, foo_15, foo_16, foo_17, foo_18, foo_19, foo_20, foo_21\nFROM \n    table1\nJOIN \n    table2 ON table2.foo_0 = table1.foo_0\nWHERE \n    table1.bar1 >= NOW()\n    AND table2.foo_20 = "tada"\nORDER BY \n    date DESC\nLIMIT 0, 10;