WITH ranked_history AS (\n  SELECT car_id, owner_id, start_date,\n         ROW_NUMBER() OVER (PARTITION BY car_id ORDER BY start_date DESC) AS rank\n  FROM car_owner_history\n  WHERE start_date <= ?\n)\nSELECT o.name, c.id AS car_id\nFROM owners o\nJOIN ranked_history rh ON o.id = rh.owner_id\nJOIN cars c ON rh.car_id = c.id\nWHERE rh.rank = 1