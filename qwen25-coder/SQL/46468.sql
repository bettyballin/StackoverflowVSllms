SELECT \n  CASE \n    WHEN Product IN ('Apple', 'Orange', 'Banana') THEN 'Fruit'\n    ELSE Product\n  END AS Product,\n  Quantity\nFROM \n  YourTable;