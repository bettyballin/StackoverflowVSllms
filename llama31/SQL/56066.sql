SELECT \n  product_id, \n  SUM(quantity) as total_quantity\nFROM \n  OrdersProducts\nGROUP BY \n  product_id\nORDER BY \n  total_quantity DESC;