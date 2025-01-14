SELECT \n    a.Activity, \n    SUM(i.Amount) AS "Total Amount 2009",\n    COALESCE(SUM(i2008.Amount), 0) AS "Total Amount 2008"\nFROM \n    Activities a\nJOIN \n    Incomes i ON a.ActivityID = i.ActivityId\nLEFT JOIN \n    Incomes2008 i2008 ON a.ActivityID = i2008.ActivityId\nWHERE \n    a.UnitName = ?\nGROUP BY \n    a.Activity\nORDER BY \n    a.Activity;