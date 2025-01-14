SELECT \n    a.BankName AS Bank, \n    a.AcctNumber AS AcctNum, \n    a.Balance, \n    IFNULL(GROUP_CONCAT(ag.GroupName ORDER BY ag.GroupName SEPARATOR ', '), '-') AS Groups\nFROM \n    Accounts a\nLEFT JOIN \n    JoinAccountsGroups jag ON a.id = jag.aid\nLEFT JOIN \n    AccountGroups ag ON jag.gid = ag.id\nGROUP BY \n    a.id, a.BankName, a.AcctNumber, a.Balance;