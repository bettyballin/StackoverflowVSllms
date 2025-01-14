SELECT \n    M.ID,\n    M.MDESC,\n    STUFF((SELECT ', ' + D.DID\n             FROM DETAIL D\n             WHERE M.ID = D.MID\n             FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') AS DetailList\nFROM MASTER M\nGROUP BY M.ID, M.MDESC;