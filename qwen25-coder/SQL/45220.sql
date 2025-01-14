SELECT \n    customers.customer_id,\n    customers.name,\n    orders.order_id,\n    orders.order_date\nFROM \n    customers\nLEFT JOIN \n    orders ON customers.customer_id = orders.customer_id;