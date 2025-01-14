DECLARE @N INT = 3; -- Replace with your desired N value\n\nSELECT TOP 1 Salary\nFROM (\n    SELECT DISTINCT TOP (@N) Salary\n    FROM Employee\n    ORDER BY Salary DESC\n) AS TopNSalaries\nORDER BY Salary ASC;