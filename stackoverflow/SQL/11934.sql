SELECT i.*, p1.*\nFROM ingredients i\n JOIN ingredient_prices p1 ON (i.id = p1.ingredient_id)\n LEFT OUTER JOIN ingredient_prices p2 ON (i.id = p2.ingredient_id \n   AND p1.created_at < p2.created_at)\nWHERE p2.id IS NULL;