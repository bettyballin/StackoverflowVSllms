UPDATE T1\nSET T1.Name = T2.Name\nFROM Table1 T1\nINNER JOIN Table2 T2\nON T1.ID = T2.ID\nWHERE T1.Name IS NULL;