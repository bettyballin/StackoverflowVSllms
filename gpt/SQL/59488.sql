WITH PopularIDs AS (\n    SELECT ID\n    FROM YourTable\n    -- Apply your criteria for popular IDs, e.g., a WHERE clause or GROUP BY with a HAVING clause\n)\nSELECT \n    p.ID, \n    t.property1, \n    t.property2,\n    (SELECT COUNT(*) FROM AnotherTable a WHERE a.ForeignID = p.ID) AS PropertyCount\nFROM \n    PopularIDs p\nJOIN \n    AnotherTable t ON p.ID = t.ID