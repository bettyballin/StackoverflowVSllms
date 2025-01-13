SELECT product_id, SUM(quantity) AS total_quantity\nFROM OrdersProducts\nGROUP BY product_id\nORDER BY total_quantity DESC;