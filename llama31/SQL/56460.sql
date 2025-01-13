-- delete in batches of 1000\nDECLARE @batch_size INT = 1000;\nDECLARE @id_list TABLE (id INT);\n\n-- populate @id_list with the IDs to delete\nINSERT INTO @id_list (id) VALUES (123), (345), ...;\n\nWHILE EXISTS (SELECT 1 FROM @id_list)\nBEGIN\n    DELETE TOP (@batch_size) FROM OUR_TABLE\n    WHERE ID IN (SELECT id FROM @id_list);\n\n    DELETE FROM @id_list\n    WHERE id IN (SELECT id FROM OUR_TABLE WHERE ID IN (SELECT id FROM @id_list));\nEND;