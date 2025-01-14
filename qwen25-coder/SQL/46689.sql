-- Create a temp table\nCREATE TABLE #TempNewAccounts (AccountNum INT, Name VARCHAR(255))\n\n-- Insert new data into temp table\nINSERT INTO #TempNewAccounts(AccountNum, Name)\nSELECT AccountNum, Name FROM AccountsNew\n\n-- Find accounts added since last run\nINSERT INTO AccountsAdded(AccountNum, Name)\nSELECT t.AccountNum, t.Name \nFROM #TempNewAccounts t\nWHERE NOT EXISTS (SELECT 1 FROM AccountsCurrent c WHERE c.AccountNum = t.AccountNum)\n\n-- Find accounts removed since last run\nINSERT INTO AccountsRemoved(AccountNum, Name)\nSELECT c.AccountNum, c.Name \nFROM AccountsCurrent c\nWHERE NOT EXISTS (SELECT 1 FROM #TempNewAccounts t WHERE t.AccountNum = c.AccountNum)\n\n-- Update AccountsCurrent with the latest data\nDELETE FROM AccountsCurrent\n\nINSERT INTO AccountsCurrent(AccountNum, Name)\nSELECT AccountNum, Name FROM #TempNewAccounts\n\n-- Drop the temp table\nDROP TABLE #TempNewAccounts