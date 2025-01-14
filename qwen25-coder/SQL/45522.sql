SELECT \n    Company.CompanyName, -- Assuming you have a column for company name or ID\n    CASE \n        WHEN Orders.OrderDate <= Companies.YearEndingDate THEN YEAR(Orders.OrderDate)\n        ELSE YEAR(Orders.OrderDate) + 1\n    END AS CustomYear,\n    SUM(Orders.OrderValue) AS TotalOrderValue\nFROM \n    Orders\nINNER JOIN \n    Companies ON Companies.CompanyID = Orders.CompanyID\nGROUP BY \n    Company.CompanyName, -- or Company.CompanyID if you're using the ID\n    CASE \n        WHEN Orders.OrderDate <= Companies.YearEndingDate THEN YEAR(Orders.OrderDate)\n        ELSE YEAR(Orders.OrderDate) + 1\n    END;