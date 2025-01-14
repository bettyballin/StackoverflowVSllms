SELECT \n    EmailAddress,\n    STUFF((\n        SELECT ', ' + Column2\n        FROM YourTableName t2\n        WHERE t1.EmailAddress = t2.EmailAddress\n        FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') AS Column2\nFROM \n    YourTableName t1\nGROUP BY \n    EmailAddress;