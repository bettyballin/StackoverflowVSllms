SELECT B, C\nFROM YourTableName\nWHERE B IN (\n    SELECT B\n    FROM YourTableName\n    GROUP BY B\n    HAVING COUNT(B) > 1\n);