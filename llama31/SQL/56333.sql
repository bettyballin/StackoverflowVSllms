SELECT p.*\nFROM ParentTable p\nJOIN SecondTable s ON p.Office_Code LIKE s.Code_Wildcard