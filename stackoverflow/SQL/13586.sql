CREATE TABLE #t (uniqueid int)\nINSERT INTO #t EXEC p_YourStoredProc\n\nUPDATE TargetTable \nSET a.FlagColumn = 1\nFROM TargetTable a JOIN #t b \n    ON a.uniqueid = b.uniqueid\n\nDROP TABLE #t