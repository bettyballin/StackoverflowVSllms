-- Insert items\nINSERT INTO Items (item_name) VALUES ('Item1'), ('Item2');\n\n-- Insert tags\nINSERT INTO Tags (tag_name) VALUES ('php'), ('upload'), ('recursive');\n\n-- Link items with tags\nINSERT INTO ItemTags (item_id, tag_id) VALUES (1, 1), (1, 2), (2, 1), (2, 3);