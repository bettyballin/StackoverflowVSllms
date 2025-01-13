SELECT \n  ID,\n  CASE \n    WHEN COUNT(CASE WHEN DATEPART(month, DATETIME) BETWEEN 1 AND 6 THEN 1 END) > 0 \n     AND COUNT(CASE WHEN DATEPART(month, DATETIME) BETWEEN 7 AND 12 THEN 1 END) = 0 \n      THEN 'Only submitted January-June data'\n    WHEN COUNT(CASE WHEN DATEPART(month, DATETIME) BETWEEN 1 AND 6 THEN 1 END) = 0 \n     AND COUNT(CASE WHEN DATEPART(month, DATETIME) BETWEEN 7 AND 12 THEN 1 END) > 0 \n      THEN 'Only submitted July-December data'\n    ELSE 'Submitted full data'\n  END AS SubmissionStatus\nFROM \n  YourTable\nGROUP BY \n  ID