SELECT product_id, SUM(amount) as total_sales \nFROM sales \nGROUP BY product_id\nORDER BY total_sales DESC;