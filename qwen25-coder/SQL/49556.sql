SELECT \n    Temp.RowNum,\n    Temp.Name\nFROM (\n    SELECT \n        (SELECT COUNT(*) FROM PuppyNames p2 WHERE p2.NumberOfVotes >= p1.NumberOfVotes) AS RowNum,\n        Name\n    FROM PuppyNames p1\n    ORDER BY NumberOfVotes\n) AS Temp\nWHERE Temp.RowNum <= 3\nORDER BY Temp.RowNum