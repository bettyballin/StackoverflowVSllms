SELECT t1.Foo, t2.Bar\nFROM table1 t1\nINNER JOIN table2 t2\nON t1.VarcharKey = t2.VarcharKey\nWHERE t1.VarcharKey = 'Foo'\nAND t2.VarcharKey = 'Foo'