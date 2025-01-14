SELECT name \nFROM aggregations \nWHERE element IN (2, 3) -- specify your list of target elements here\nGROUP BY name\nHAVING COUNT(DISTINCT element) = 2 -- this should match the number of distinct elements in the WHERE clause\nAND NOT EXISTS (\n    SELECT 1 \n    FROM aggregations a2 \n    WHERE a2.name = aggregations.name \n    AND a2.element NOT IN (2, 3) -- ensure no other elements exist\n);