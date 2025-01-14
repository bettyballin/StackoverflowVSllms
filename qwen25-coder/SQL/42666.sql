SELECT TRUNC(closedate, 'MONTH') AS month_start, COUNT(*) AS transaction_count\nFROM MY_TRANSACTIONS\nGROUP BY TRUNC(closedate, 'MONTH')\nORDER BY month_start;