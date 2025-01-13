SELECT \n    ROW_NUMBER = IDENTITY(INT, 1, 1),\n    Name\nINTO #TempTable\nFROM \n    PuppyNames\nORDER BY \n    NumberOfVotes\n\nSELECT TOP 3 * FROM #TempTable\nDROP TABLE #TempTable