-- Assuming you have a table named 'orders' with columns: id, customer_id, product_id, quantity\n\nSELECT customer_id, product_id, SUM(quantity) AS total_quantity\nFROM orders\nGROUP BY customer_id;