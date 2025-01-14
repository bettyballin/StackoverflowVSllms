-- Trigger to format 'your_column' on INSERT\nDELIMITER //\nCREATE TRIGGER before_insert_your_table\nBEFORE INSERT ON your_table\nFOR EACH ROW\nBEGIN\n    SET NEW.your_column = CONCAT(\n        LEFT(NEW.your_column, 3), '/',\n        SUBSTRING(NEW.your_column, 4, 3), '/',\n        SUBSTRING(NEW.your_column, 7, 3), '/',\n        RIGHT(NEW.your_column, 4)\n    );\nEND//\nDELIMITER ;