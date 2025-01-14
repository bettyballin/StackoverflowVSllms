SELECT \n    AbsenceDate,\n    CASE \n        WHEN MONTH(AbsenceDate) >= 8 -- August or later\n            THEN CAST(YEAR(AbsenceDate) AS VARCHAR(4)) + '/' + CAST(YEAR(AbsenceDate) + 1 AS VARCHAR(4))\n        ELSE\n            CAST(YEAR(AbsenceDate) - 1 AS VARCHAR(4)) + '/' + CAST(YEAR(AbsenceDate) AS VARCHAR(4))\n    END AS AcademicYear\nFROM \n    Absences