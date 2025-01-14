SELECT \n    omID,\n    fruit.value('(imageId/text())[1]', 'int') AS imageId,\n    fruit.value('(title/text())[1]', 'nvarchar(100)') AS title\nFROM \n    dbo.myTable\nCROSS APPLY \n    omText.nodes('/things/Fruit') AS XT(fruit)\nWHERE \n    fruit.value('(title/text())[1]', 'nvarchar(100)') = 'Apple'