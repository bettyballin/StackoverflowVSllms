SELECT \n    Code,\n    Number,\n    ROW_NUMBER() OVER (PARTITION BY Code ORDER BY Number) AS Seq\nFROM \n    YourTable;