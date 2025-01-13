SELECT \n    t1.AccountNo, \n    t1.Balance, \n    t2.Balance, \n    t1.Balance / NULLIF(t2.Balance, 0) AS BalanceRatio\nFROM \n    temp1 t1\nJOIN \n    temp2 t2 ON t1.AccountNo = t2.AccountNo\nWHERE \n    (t1.Balance / NULLIF(t2.Balance, 0) > 1.1 OR t1.Balance / NULLIF(t2.Balance, 0) < 0.9);