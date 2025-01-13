-- example optimization in SQL Server\n-- before: SELECT * FROM users WHERE id IN (SELECT user_id FROM orders);\n-- after: SELECT * FROM users u WHERE EXISTS (SELECT 1 FROM orders o WHERE o.user_id = u.id);