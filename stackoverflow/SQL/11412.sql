SELECT  CustomerID, MAX(Date)\nFROM    Purchase\nGROUP BY CustomerID, YEAR(Date), MONTH(Date)