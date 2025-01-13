SELECT *\nFROM (\n  SELECT customer_id, category, quantity,\n         SYS_CONNECT_BY_PATH(category, ',') AS categories\n  FROM orders\n  START WITH category IS NOT NULL\n  CONNECT BY PRIOR category = category\n)\nUNPIVOT (\n  quantity\n  FOR category IN (SELECT DISTINCT category FROM orders)\n);