-- Example: Subquery to CTE transformation\n   SELECT * FROM Orders WHERE customer_id IN (SELECT id FROM Customers WHERE last_order_date > '2023-01-01');\n   \n   -- Equivalent using CTE\n   WITH RecentCustomers AS (\n       SELECT id FROM Customers WHERE last_order_date > '2023-01-01'\n   )\n   SELECT * FROM Orders WHERE customer_id IN (SELECT id FROM RecentCustomers);