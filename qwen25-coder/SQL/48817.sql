SELECT AVG(AverageGrade) as YearAverage\nFROM Grades\nWHERE StudentID = ? AND SubjectID = ?\nAND PeriodID IN (\n    SELECT PeriodID FROM GradingPeriods WHERE Year = ?\n);