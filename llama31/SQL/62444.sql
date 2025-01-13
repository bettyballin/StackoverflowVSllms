CREATE TABLE #TempDates (DATE datetime, DATE_NO int);\nINSERT INTO #TempDates (DATE, DATE_NO)\nSELECT DATE, DATE_NO FROM Dates;\n\nCREATE INDEX idx.DATE ON #TempDates (DATE);\n\nUPDATE t\nSET EndTimeKey = td.DATE_NO\nFROM TableToUpdate t\nINNER JOIN #TempDates td ON t.EndTime = td.DATE;