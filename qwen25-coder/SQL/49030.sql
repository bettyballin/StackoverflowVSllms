-- Example: Subquery to EXISTS transformation\n   SELECT * FROM Inventory i WHERE (SELECT COUNT(*) FROM Orders o WHERE o.product_id = i.id AND status = 'Pending') > 0;\n   \n   -- Equivalent using EXISTS\n   SELECT * FROM Inventory i WHERE EXISTS (SELECT 1 FROM Orders o WHERE o.product_id = i.id AND status = 'Pending');