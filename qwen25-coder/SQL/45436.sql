WITH RECURSIVE DateSeries AS (\n    SELECT MIN(date) as ds_date FROM balances\n    UNION ALL\n    SELECT DATE_ADD(ds_date, INTERVAL 5 DAY)\n    FROM DateSeries \n    WHERE ds_date < (SELECT MAX(date) FROM balances)\n),\nRankedBalances AS (\n    SELECT\n        aid,\n        balance,\n        date,\n        RANK() OVER (PARTITION BY aid ORDER BY date DESC) as rnk\n    FROM balances\n)\nSELECT\n    ds.aid,\n    COALESCE(rb.balance, LAST_VALUE(rb.balance) \n                  IGNORE NULLS OVER (PARTITION BY ds.aid ORDER BY rb.date ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW),\n                   0) as balance,\n    ds.ds_date\nFROM DateSeries ds\nLEFT JOIN RankedBalances rb ON ds.aid = rb.aid AND ds.ds_date >= rb.date\nGROUP BY ds.aid, ds.ds_date;