SELECT t2.State, t2.Product, t2.Version\nFROM Table2 t2\nLEFT JOIN Table1 t1\nON t2.State = t1.State AND t2.Product = t1.Product AND t1.Distributor = 'X'\nWHERE t1.Distributor IS NULL;