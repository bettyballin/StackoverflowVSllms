-- Assuming we have a way to map equivalent IDs in Table A from DEV to TEST environments\nWITH DevData AS (\n    SELECT Name, ROW_NUMBER() OVER (ORDER BY Name) AS RowNum\n    FROM DEV.TableA\n),\nTestData AS (\n    SELECT Name, ROW_NUMBER() OVER (ORDER BY Name) AS RowNum\n    FROM TEST.TableA\n)\nSELECT \n    D.Name AS DevName,\n    T.Name AS TestName\nFROM \n    DevData D\nFULL OUTER JOIN \n    TestData T ON D.RowNum = T.RowNum AND D.Name <> T.Name\nWHERE \n    D.Name IS NULL OR T.Name IS NULL;\n\n-- Similarly for Table B, consider using the mapped RowNums from Table A\nWITH DevTableB AS (\n    SELECT a.RowNum, b.Category\n    FROM DEV.TableA a\n    JOIN DEV.TableB b ON a.ID = b.FK_ID\n),\nTestTableB AS (\n    SELECT a.RowNum, b.Category,\n           ROW_NUMBER() OVER (PARTITION BY a.Name ORDER BY b.Category) AS CatRowNum\n    FROM TEST.TableA a\n    JOIN TEST.TableB b ON a.ID = b.FK_ID\n)\nSELECT \n    D.Category AS DevCategory,\n    T.Category AS TestCategory\nFROM \n    DevTableB D\nFULL OUTER JOIN \n    TestTableB T ON D.RowNum = T.RowNum AND D.CatRowNum = T.CatRowNum AND D.Category <> T.Category\nWHERE \n    D.Category IS NULL OR T.Category IS NULL;