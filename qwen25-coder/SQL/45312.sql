SELECT Name\n   FROM your_table\n   GROUP BY Name\n   HAVING COUNT(CASE WHEN LeftID IS NULL AND RightId IS NULL THEN 1 END) = COUNT(*);