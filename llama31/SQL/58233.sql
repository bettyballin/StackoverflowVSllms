SELECT Name\nFROM your_table\nWHERE LeftId IS NULL AND RightId IS NULL\nGROUP BY Name\nHAVING COUNT(*) = (SELECT COUNT(*) FROM your_table WHERE Name = your_table.Name);