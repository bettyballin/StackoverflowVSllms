SELECT \n  p.id, \n  p.long_name AS name, \n  COALESCE(SUM(oi.quantity), 0) AS sold\nFROM \n  products p\n  LEFT JOIN orderitems oi ON p.id = oi.product_id\n  LEFT JOIN orders o ON oi.order_id = o.id AND o.paid = 1\nGROUP BY \n  p.id, p.long_name