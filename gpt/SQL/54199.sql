SELECT \n     first_name, last_name, score,\n     RANK() OVER (ORDER BY score DESC) AS rank\n   FROM \n     math_scores