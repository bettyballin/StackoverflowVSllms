SELECT \n  G.GroupName AS Name, \n  COUNT(A.ID) AS Count, \n  SUM(A.Balance) AS Balance\nFROM \n  AccountGroups G\n  LEFT JOIN JoinAccountsGroups J ON G.ID = J.GID\n  LEFT JOIN Accounts A ON J.AID = A.ID\nGROUP BY \n  G.GroupName\n\nSELECT \n  A.BankName AS Bank, \n  A.AcctNumber AS AcctNum, \n  A.Balance\nFROM \n  Accounts A\n  LEFT JOIN JoinAccountsGroups J ON A.ID = J.AID\n  LEFT JOIN AccountGroups G ON J.GID = G.ID\nWHERE \n  G.GroupName = ?  -- Replace with the group name