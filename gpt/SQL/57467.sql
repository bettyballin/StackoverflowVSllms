-- Add an index on item_id column\nCREATE INDEX idx_item_id ON items(item_id);\n\n-- Use the following query for better performance\nSELECT * FROM items WHERE item_id LIKE 'Sb%';