-- Denormalized table\nCREATE TABLE user_orders (\n    user_id INT,\n    user_name VARCHAR(100),\n    order_id INT,\n    product VARCHAR(100)\n);