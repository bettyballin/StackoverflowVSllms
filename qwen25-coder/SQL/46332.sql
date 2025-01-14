WITH PopularIDs AS (\n    SELECT TOP 10 ID -- Adjust as necessary\n    FROM YourTable\n    ORDER BY SomeCriteria DESC\n)\nSELECT \n    p.ID,\n    a.Property1,\n    a.Property2,\n    (SELECT COUNT(*)\n     FROM AnotherTable at\n     WHERE at.ForeignID = p.ID) AS CountOfRelatedRows\nFROM PopularIDs p\nJOIN AnotherTable a ON p.ID = a.ForeignID -- Adjust the join condition as needed\nORDER BY p.ID;