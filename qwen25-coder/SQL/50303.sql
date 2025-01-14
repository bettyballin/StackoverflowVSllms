-- Example of a constraint for data integrity (simple validation)\nALTER TABLE orders \nADD CONSTRAINT chk_quantity CHECK(quantity > 0);\n\n-- Example of a trigger for complex logic\nCREATE TRIGGER update_inventory\nAFTER INSERT ON sales\nFOR EACH ROW\nBEGIN\n    UPDATE inventory\n    SET stock = stock - NEW.quantity\n    WHERE product_id = NEW.product_id;\n    \n    IF (SELECT stock FROM inventory WHERE product_id = NEW.product_id) < 0 THEN\n        RAISE_APPLICATION_ERROR(-20005, 'Insufficient Stock');\n    END IF;\nEND;