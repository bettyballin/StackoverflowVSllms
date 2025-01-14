SELECT \n    t1.ID, \n    t1.Cat, \n    t1.Price, \n    NULL as Name, \n    NULL as Abbrv, \n    ROW_NUMBER() OVER (PARTITION BY t1.ID ORDER BY t1.Price DESC) as RowOrder\nFROM t1 \nUNION ALL\nSELECT \n    t2.ID, \n    NULL as Cat, \n    NULL as Price, \n    t2.Name, \n    t2.Abbrv,\n    ROW_NUMBER() OVER (PARTITION BY t2.ID ORDER BY t2.Abbrv ASC) as RowOrder\nFROM t2 \nORDER BY ID, RowOrder;