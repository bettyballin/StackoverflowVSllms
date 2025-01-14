WITH AccountBalances AS (\n    SELECT \n        account_id, \n        date,\n        amount,\n        ROW_NUMBER() OVER (PARTITION BY account_id, date ORDER BY id ASC) AS rn_min,\n        ROW_NUMBER() OVER (PARTITION BY account_id, date ORDER BY id DESC) AS rn_max\n    FROM \n        your_table\n)\nSELECT \n    account_id,\n    date,\n    MAX(CASE WHEN rn_min = 1 THEN amount END) AS opening_balance,\n    MAX(CASE WHEN rn_max = 1 THEN amount END) AS closing_balance\nFROM \n    AccountBalances\nGROUP BY \n    account_id, date\nORDER BY \n    account_id, date;