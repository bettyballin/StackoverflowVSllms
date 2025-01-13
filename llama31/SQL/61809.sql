SELECT \n    C.Company,\n    SUM(O.orderValue) AS TotalOrderValue,\n    -- Calculate the custom year based on the YearEndingDate\n    CASE \n        WHEN DATEPART(MONTH, O.OrderDate) > DATEPART(MONTH, C.YearEndingDate) \n             OR (DATEPART(MONTH, O.OrderDate) = DATEPART(MONTH, C.YearEndingDate) \n                 AND DATEPART(DAY, O.OrderDate) > DATEPART(DAY, C.YearEndingDate))\n        THEN DATEPART(YEAR, O.OrderDate) + 1\n        ELSE DATEPART(YEAR, O.OrderDate)\n    END AS CustomYear\nFROM Orders O\nINNER JOIN Company C ON C.CompanyID = O.CompanyID\nGROUP BY C.Company, \n         -- Include the custom year calculation in the GROUP BY clause\n         CASE \n             WHEN DATEPART(MONTH, O.OrderDate) > DATEPART(MONTH, C.YearEndingDate) \n                  OR (DATEPART(MONTH, O.OrderDate) = DATEPART(MONTH, C.YearEndingDate) \n                      AND DATEPART(DAY, O.OrderDate) > DATEPART(DAY, C.YearEndingDate))\n             THEN DATEPART(YEAR, O.OrderDate) + 1\n             ELSE DATEPART(YEAR, O.OrderDate)\n         END\nORDER BY C.Company, CustomYear;