SELECT \n    (SELECT COUNT(CaseID) FROM dbo.ClientCase \n     WHERE CaseStartDate >= CONVERT(DATETIME, '2009-01-01 00:00:00', 102) \n       AND CaseStartDate <= CONVERT(DATETIME, '2009-03-31 00:00:00', 102)) AS 'New Cases',\n    (SELECT COUNT(CaseID) FROM dbo.ClientCase \n     WHERE CaseClosedDate >= CONVERT(DATETIME, '2009-01-01 00:00:00', 102) \n       AND CaseClosedDate <= CONVERT(DATETIME, '2009-03-31 00:00:00', 102)) AS 'Closed Cases',\n    (SELECT COUNT(CaseID) FROM dbo.ClientCase \n     WHERE CaseStartDate <= CONVERT(DATETIME, '2009-03-31 00:00:00', 102)) AS 'Existing Cases'