SELECT \n  SUBSTR(date, 0, 7) AS "month",\n  SUM(CASE WHEN amount > 0 THEN amount ELSE 0 END) AS "income",\n  SUM(CASE WHEN amount < 0 THEN amount ELSE 0 END) AS "expenses"\nFROM posts\nGROUP BY month\nORDER BY date;