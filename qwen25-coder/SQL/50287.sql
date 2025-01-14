SELECT DISTINCT o.orderID\n   FROM orders o\n   LEFT JOIN tasks t ON o.orderID = t.orderID AND (t.engineer1 IS NOT NULL OR t.engineer2 IS NOT NULL)\n   WHERE t.taskID IS NULL;