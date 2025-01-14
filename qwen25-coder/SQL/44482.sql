WITH RunningTotal AS (\n    SELECT \n        account,\n        transaction_date,\n        Points,\n        SUM(Points) OVER(PARTITION BY account ORDER BY transaction_date ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) as running_total\n    FROM \n        transactions\n)\nSELECT \n    account,\n    MIN(transaction_date) as threshold_reached_date\nFROM \n    RunningTotal\nWHERE \n    running_total >= 100\nGROUP BY \n    account;