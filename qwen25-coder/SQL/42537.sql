SELECT COUNT(DISTINCT productId) AS uniqueProductCount\nFROM your_table_name\nWHERE keyword = '$keyword';