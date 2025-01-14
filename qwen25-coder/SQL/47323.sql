SELECT \n    A.AccountId,\n    A.AccountBalanceDate,\n    SUM(CASE WHEN BT.BalanceId = OpeningBal.BalanceId THEN BT.TokenAmount ELSE 0 END) AS OpeningBalance,\n    SUM(CASE WHEN BT.BalanceId = ClosingBal.BalanceId THEN BT.TokenAmount ELSE 0 END) AS ClosingBalance\nFROM \n    Account A\nLEFT JOIN \n    Balance OpeningBal ON A.OpeningBalanceId = OpeningBal.BalanceId\nLEFT JOIN \n    Balance ClosingBal ON A.ClosingBalanceId = ClosingBal.BalanceId\nLEFT JOIN \n    BalanceToken BT ON (BT.BalanceId = OpeningBal.BalanceId OR BT.BalanceId = ClosingBal.BalanceId)\nGROUP BY \n    A.AccountId, \n    A.AccountBalanceDate;