UPDATE t1\nSET t1.Name = t2.Name\nFROM Table1 t1\nINNER JOIN Table2 t2\nON t1.ID = t2.ID;