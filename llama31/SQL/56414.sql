SELECT \n  SUM(rating * weight) / SUM(weight) AS weighted_mean\nFROM \n  your_table;