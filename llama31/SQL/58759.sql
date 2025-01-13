CREATE OR REPLACE TRIGGER LabEx5_1\nAFTER INSERT ON Concessions_sold\nFOR EACH ROW\nBEGIN\n  IF INSERTING THEN\n    UPDATE inventory i\n    SET i.quantity = i.quantity - :NEW.quantity\n    WHERE i.inventory_id = (SELECT c.inventory_id\n                            FROM concession c\n                            WHERE c.concession_id = :NEW.concession_id);\n  END IF;\nEND LabEx5_1;\n/