-- Trigger for INSERT on StoreItem association table\n    DELIMITER //\n    CREATE TRIGGER after_store_item_insert\n    AFTER INSERT ON StoreItem\n    FOR EACH ROW\n    BEGIN\n        INSERT INTO ChangeLog (user_id, action, table_name, record_id, changes)\n        VALUES (NEW.user_id, 'INSERT', 'StoreItem', NEW.id, CONCAT('Item associated with Store. Store ID: ', NEW.store_id, ', Item ID: ', NEW.item_id));\n    END;\n    //\n    DELIMITER ;\n\n    -- Trigger for DELETE on StoreItem association table\n    DELIMITER //\n    CREATE TRIGGER after_store_item_delete\n    AFTER DELETE ON StoreItem\n    FOR EACH ROW\n    BEGIN\n        INSERT INTO ChangeLog (user_id, action, table_name, record_id, changes)\n        VALUES (OLD.user_id, 'DELETE', 'StoreItem', OLD.id, CONCAT('Item dissociated from Store. Store ID: ', OLD.store_id, ', Item ID: ', OLD.item_id));\n    END;\n    //\n    DELIMITER ;