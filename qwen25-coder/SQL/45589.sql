SELECT \n       A.BankName AS Bank, \n       A.AcctNumber AS AcctNum, \n       A.Balance, \n       ConcatRelated("GroupName", "JoinAccountsGroups AS JG INNER JOIN AccountGroups AS AG ON JG.gid = AG.id", "JG.aid = " & A.id) AS Groups\n   FROM Accounts AS A;