SELECT COUNT(*)\nFROM conditionentrytable c\nWHERE conditionlevelentryid = 189\n  AND (\n    (c.checkoffdate IS NULL AND c.conditionentrydatetime < DATEADD(day, -14, GETDATE()))\n    OR \n    (c.checkoffdate IS NOT NULL AND DATEDIFF(day, c.conditionentrydatetime, c.checkoffdate) > 14)\n  )