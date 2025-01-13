SELECT \n  product_ID,\n  SUM(quantity) AS total_items_sold,\n  SUM(CASE WHEN order_date >= '01/01/09' THEN quantity ELSE 0 END) AS items_sold_since_date\nFROM \n  Sales\nGROUP BY \n  product_ID