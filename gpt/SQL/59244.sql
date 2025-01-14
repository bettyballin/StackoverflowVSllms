SELECT \n    cust_id,\n    (COUNT(order_id) * 100.0 / (SELECT COUNT(order_id) FROM orders)) AS percentage_of_sales\nFROM \n    orders\nWHERE \n    cust_id = 541\nGROUP BY \n    cust_id;