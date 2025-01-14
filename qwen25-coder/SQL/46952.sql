SELECT \n    UserId,\n    STUFF((\n        SELECT ', ' + Alias\n        FROM UserAliases AS ua2\n        WHERE ua2.UserId = ua1.UserId\n        FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') AS Aliases\nFROM \n    UserAliases AS ua1\nGROUP BY \n    UserId;