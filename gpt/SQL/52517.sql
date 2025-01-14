DELIMITER //\n\nCREATE TRIGGER before_insert_items\nBEFORE INSERT ON items\nFOR EACH ROW\nBEGIN\n    SET NEW.other_field = (SELECT AUTO_INCREMENT\n                           FROM information_schema.TABLES\n                           WHERE TABLE_SCHEMA = DATABASE()\n                           AND TABLE_NAME = 'items');\nEND;\n//\n\nDELIMITER ;