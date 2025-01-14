SELECT \n    TransactionCode,\n    TenantID,\n    SUM(CASE WHEN Amount > 0 THEN Amount ELSE 0 END) AS Paid,\n    SUM(CASE WHEN Amount < 0 AND TransactionDate > DATEADD("dd", -30, GETDATE()) THEN Amount ELSE 0 END) AS ChargedCurrent,\n    SUM(CASE WHEN Amount < 0 AND TransactionDate BETWEEN DATEADD("dd", -60, GETDATE()) AND DATEADD("dd", -31, GETDATE()) THEN Amount ELSE 0 END) AS ChargedOver30,\n    SUM(CASE WHEN Amount < 0 AND TransactionDate BETWEEN DATEADD("dd", -90, GETDATE()) AND DATEADD("dd", -61, GETDATE()) THEN Amount ELSE 0 END) AS ChargedOver60,\n    SUM(CASE WHEN Amount < 0 AND TransactionDate <= DATEADD("dd", -91, GETDATE()) THEN Amount ELSE 0 END) AS ChargedOver90\nFROM \n    tblTransaction\nGROUP BY \n    TransactionCode,\n    TenantID;