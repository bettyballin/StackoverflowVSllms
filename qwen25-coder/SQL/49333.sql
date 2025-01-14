CREATE VIEW user_orders_summary AS\nSELECT \n    u.user_id,\n    u.name,\n    COUNT(o.order_id) AS total_orders,\n    SUM(o.amount) AS total_spent\nFROM \n    users u\nJOIN \n    orders o ON u.user_id = o.customer_id\nGROUP BY \n    u.user_id, u.name;