SELECT \n    p.product_id,\n    p.product_name,\n    (COALESCE(SUM(b.quantity), 0) - COALESCE(SUM(s.quantity), 0)) AS available_stock\nFROM \n    products p\nLEFT JOIN \n    bought b ON p.product_id = b.product_id\nLEFT JOIN \n    sold s ON p.product_id = s.product_id\nGROUP BY \n    p.product_id, p.product_name;