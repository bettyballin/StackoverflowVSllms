ALTER TABLE items_2023\n    DROP CONSTRAINT "$1";\nALTER TABLE items_2023\n    ADD CONSTRAINT "$1" FOREIGN KEY (order_id) REFERENCES orders_2023(id) ON DELETE CASCADE;