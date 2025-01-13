SELECT \n    a.BankName AS Bank, \n    a.AcctNumber AS AcctNum, \n    a.Balance, \n    Nz(GROUP_CONCAT(g.GroupName, ', '), '-') AS Groups\nFROM \n    Accounts a\nLEFT JOIN \n    JoinAccountsGroups j ON a.ID = j.AID\nLEFT JOIN \n    AccountGroups g ON j.GID = g.ID\nGROUP BY \n    a.BankName, a.AcctNumber, a.Balance;