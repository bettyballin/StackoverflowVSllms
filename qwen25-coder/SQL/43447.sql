WITH RankedItems AS (\n    SELECT \n        user_id,\n        created,\n        ROW_NUMBER() OVER (PARTITION BY user_id ORDER BY created DESC) as rn\n    FROM items\n    WHERE user_id IN (/* Your list of user ids, e.g., 1, 2, 3, ... */)\n)\n\nSELECT * FROM (\n    SELECT \n        user_id,\n        created,\n        ROW_NUMBER() OVER (ORDER BY rn, created DESC) as final_rn\n    FROM RankedItems\n) subquery\nWHERE final_rn <= 25\nORDER BY created DESC;