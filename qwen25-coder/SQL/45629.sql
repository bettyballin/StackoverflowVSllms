DECLARE @LIST NVARCHAR(MAX)\nSET @LIST = 'Bob|Mary|Joe'\n\nSELECT u.*\nFROM Users u\nJOIN dbo.SplitStringToTable (@LIST, '|') AS s ON u.FirstName = s.Value