SELECT customer.*\nFROM Customer customer\nWHERE EXISTS (\n    SELECT 1\n    FROM Orders order\n    WHERE order.customer_id = customer.id\n    AND order.order_date = (SELECT MAX(order_t2.order_date) FROM Orders order_t2 WHERE order_t2.customer_id = customer.id)\n);