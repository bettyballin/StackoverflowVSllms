SELECT \n    (SELECT COUNT(*) FROM YourTable t2 WHERE t2.YourOrderColumn < t1.YourOrderColumn) + 1 AS IncrementalId,\n    YourColumn1,\n    YourColumn2\nFROM \n    YourTable t1\nORDER BY \n    YourOrderColum