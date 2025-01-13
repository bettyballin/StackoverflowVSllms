WITH RecursiveFolders AS (\n    SELECT ItemID, ParentID, Name, 0 AS Level\n    FROM Catalog\n    WHERE ParentID IS NULL  -- anchor query: top-level folders\n    UNION ALL\n    SELECT c.ItemID, c.ParentID, c.Name, Level + 1\n    FROM Catalog c\n    INNER JOIN RecursiveFolders r ON c.ParentID = r.ItemID\n)\nSELECT \n    (\n        SELECT \n            Name AS '@name',\n            (\n                SELECT \n                    Name AS '@name'\n                FROM RecursiveFolders r2\n                WHERE r2.ParentID = r1.ItemID\n                FOR XML PATH('Report'), TYPE\n            ) AS 'Reports'\n        FROM RecursiveFolders r1\n        WHERE Level = 0\n        FOR XML PATH('ReportFolder'), TYPE\n    ) AS 'Server'\nFOR XML PATH('');