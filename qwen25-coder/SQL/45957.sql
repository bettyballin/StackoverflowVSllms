-- Assume we have two tables: `orders` and `order_items`, where order_items depends on orders.\n\n-- First, ensure all deletions mark records as deleted instead of removing them.\nCREATE TABLE orders (\n    id INT PRIMARY KEY,\n    is_deleted BOOLEAN DEFAULT FALSE\n);\n\nCREATE TABLE order_items (\n    id INT PRIMARY KEY,\n    order_id INT,\n    is_deleted BOOLEAN DEFAULT FALSE,\n    FOREIGN KEY (order_id) REFERENCES orders(id)\n);\n\n-- Create a trigger to perform cascading soft delete on orders\nDELIMITER $$\n\nCREATE TRIGGER after_orders_update \nAFTER UPDATE ON orders FOR EACH ROW\nBEGIN\n    IF NEW.is_deleted = TRUE THEN\n        -- Update all dependent records in `order_items` table\n        UPDATE order_items SET is_deleted = TRUE WHERE order_id = OLD.id;\n    END IF;\nEND$$\n\nDELIMITER ;