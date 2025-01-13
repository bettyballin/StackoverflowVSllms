SELECT account, transaction_date\nFROM (\n  SELECT account, transaction_date, \n         SUM(Points) OVER (PARTITION BY account ORDER BY transaction_date) AS cumulative_points\n  FROM your_table\n) AS subquery\nWHERE cumulative_points >= 100\nORDER BY account, transaction_date\nLIMIT 1;