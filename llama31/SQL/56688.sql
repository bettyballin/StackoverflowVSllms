SELECT *\nFROM customers\nFULL OUTER JOIN orders\nON customers.customer_id = orders.customer_id;