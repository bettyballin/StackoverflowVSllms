SELECT TOP 1 * \nFROM [myTable]\nWHERE Name = 'Test' AND Size = 2 AND PType = 'p'\nORDER BY ABS(Area - 1.125) ASC;