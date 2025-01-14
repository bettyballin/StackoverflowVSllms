SELECT \n    ID, \n    Value,\n    LAG(Value, 1, 0) OVER (PARTITION BY ID ORDER BY Value) AS Prev_Value\nFROM \n    cardevent;