WITH CustomerDistribution AS (\n  SELECT\n    c1.customer,\n    c1.food_type,\n    100 * c1.food_type_value / SUM(c2.food_type_value) OVER (PARTITION BY c1.customer) AS food_type_perc\n  FROM\n    mytable c1\n  JOIN\n    mytable c2 ON c1.customer = c2.customer\n),\nIdealCustomerDistribution AS (\n  SELECT\n    food_type,\n    100 * food_type_value / SUM(food_type_value) OVER () AS ideal_perc\n  FROM\n    mytable\n  WHERE\n    customer = 3\n)\nSELECT\n  cd.customer,\n  cd.food_type,\n  cd.food_type_perc,\n  icd.ideal_perc\nFROM\n  CustomerDistribution cd\nJOIN\n  IdealCustomerDistribution icd ON cd.food_type = icd.food_type;