WITH SplitCTE AS (\n    SELECT Id, description, 1 AS quantity\n    FROM YourTable\n    WHERE quantity > 0\n    UNION ALL\n    SELECT Id, description, quantity + 1\n    FROM YourTable T\n    JOIN SplitCTE S ON T.Id = S.Id\n    WHERE S.quantity < T.quantity\n)\nSELECT Id, description, quantity\nFROM SplitCTE\nORDER BY Id, description\nOPTION (MAXRECURSION 0);