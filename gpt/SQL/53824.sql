-- Step 1: Select distinct Usernames from tempUsers\nSELECT DISTINCT Username\nINTO #tempDistinctUsernames\nFROM tempUsers;\n\n-- Step 2: Insert the distinct Usernames into the destination table\nINSERT INTO destinationTable (Username)\nSELECT Username\nFROM #tempDistinctUsernames;\n\n-- Cleanup: Drop the temporary table\nDROP TABLE #tempDistinctUsernames;