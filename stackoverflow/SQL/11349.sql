SELECT * FROM table T1\nWHERE NOT EXISTS (SELECT * FROM Table T2 WHERE T2.ID = T1.ID - 1)