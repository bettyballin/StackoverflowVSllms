SELECT \n  c1.customer,\n  c1.food_type,\n  100 * c1.food_type_value / SUM(c2.food_type_value) AS food_type_perc,\n  100 * c3.food_type_value / SUM(c4.food_type_value) AS ideal_perc\nFROM \n  mytable c1 \n  INNER JOIN mytable c2 \n  ON c1.customer = c2.customer\n  INNER JOIN mytable c3 \n  ON c3.customer = 3 AND c3.food_type = c1.food_type\n  INNER JOIN mytable c4 \n  ON c4.customer = 3\nGROUP BY \n  c1.customer, c1.food_type, c1.food_type_value, c3.food_type_value