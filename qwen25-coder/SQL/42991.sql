SELECT * FROM categories WHERE parent_id = \n(SELECT id FROM categories WHERE name = 'Fruits');