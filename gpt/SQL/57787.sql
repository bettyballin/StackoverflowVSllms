SELECT \n    c.customer_id, \n    COUNT(o.order_id) AS total_orders,\n    COUNT(CASE WHEN o.discount = TRUE THEN 1 END) AS discounted_orders\nFROM \n    customer c\nLEFT JOIN \n    `order` o ON c.customer_id = o.customer_id\nGROUP BY \n    c.customer_id;