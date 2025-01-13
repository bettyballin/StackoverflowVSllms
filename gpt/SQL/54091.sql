-- Step 1: Create and populate the Transactions table\nCREATE TABLE Transactions (\n    TransactionDate DATE NOT NULL,\n    TransactionValue INTEGER NOT NULL\n);\n\nINSERT INTO Transactions (TransactionDate, TransactionValue)\nVALUES ('2009-01-01', 1),\n       ('2009-03-01', 2),\n       ('2009-06-01', 3);\n\n-- Step 2: Generate a list of all months between the minimum and maximum transaction dates\nWITH DateRange AS (\n    SELECT MIN(TransactionDate) AS MinDate, MAX(TransactionDate) AS MaxDate\n    FROM Transactions\n),\nMonths AS (\n    SELECT DATEADD(month, N, MinDate) AS Month\n    FROM DateRange\n    JOIN (SELECT TOP (DATEDIFF(month, (SELECT MinDate FROM DateRange), (SELECT MaxDate FROM DateRange)) + 1) \n                 ROW_NUMBER() OVER (ORDER BY s1.[object_id]) - 1 AS N\n          FROM sys.objects AS s1 CROSS JOIN sys.objects AS s2) AS Numbers\n    ON DATEADD(month, N, MinDate) <= MaxDate\n)\n-- Step 3: Use LEFT JOIN to join this list with the Transactions table\n, TransactionsWithMonths AS (\n    SELECT m.Month, t.TransactionValue\n    FROM Months m\n    LEFT JOIN Transactions t ON t.TransactionDate = m.Month\n)\n-- Step 4: Use OUTER APPLY to fill in the missing values with the most recent non-null value\nSELECT m.Month, COALESCE(t.TransactionValue, prev.TransactionValue) AS Value\nFROM TransactionsWithMonths m\nOUTER APPLY (\n    SELECT TOP 1 t2.TransactionValue\n    FROM TransactionsWithMonths t2\n    WHERE t2.Month <= m.Month AND t2.TransactionValue IS NOT NULL\n    ORDER BY t2.Month DESC\n) prev\nORDER BY m.Month;