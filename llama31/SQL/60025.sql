SELECT \n  G.GroupName AS Name, \n  COUNT(A.ID) AS Count, \n  SUM(A.Balance) AS Balance,\n  (SELECT \n     A2.BankName, \n     A2.AcctNumber, \n     A2.Balance\n   FROM \n     Accounts A2\n     LEFT JOIN JoinAccountsGroups J2 ON A2.ID = J2.AID\n   WHERE \n     J2.GID = G.ID) AS Accounts\nFROM \n  AccountGroups G\n  LEFT JOIN JoinAccountsGroups J ON G.ID = J.GID\n  LEFT JOIN Accounts A ON J.AID = A.ID\nGROUP BY \n  G.GroupName