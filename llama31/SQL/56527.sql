SELECT \n    CONVERT(date, YourDateField) AS Date,\n    MAX(YourNumericalField) AS MaxDailyValue\nFROM \n    YourTableName\nWHERE \n    YourDateField >= DATEFROMPARTS(YEAR(GETDATE()) - 1, 1, 1)\n    AND YourDateField < DATEFROMPARTS(YEAR(GETDATE()), 1, 1)\nGROUP BY \n    CONVERT(date, YourDateField)\nORDER BY \n    MaxDailyValue DESC;