SELECT \n    COALESCE(t1.Name, 'Item Inexistent') as Name,\n    t2.IntValue\nFROM \n    Table2 t2\nLEFT JOIN \n    Table1 t1\nON \n    t2.Table1_ID = t1.Id;