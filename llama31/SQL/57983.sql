CREATE OR REPLACE TRIGGER my_trigger\nAFTER INSERT ON my_table\nFOR EACH ROW\nBEGIN\n    -- Do something...\n    INSERT INTO another_table VALUES (:NEW.id);\nEND;\n/