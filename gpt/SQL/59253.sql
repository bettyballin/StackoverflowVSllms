SELECT\n   t1.Col1,\n   t1.Col2,\n   t1.Col3,\n   t1.Col4\nFROM\n   table1 t1\nJOIN \n   table2 t2 \nON \n   t2.Col1 = t1.Col1 OR t2.Col1 = t1.Col2