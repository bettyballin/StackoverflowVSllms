WITH TopRows AS (\n    SELECT TOP 5 \n        columnB,(columnA),\n        ROW_NUMBER() OVER (ORDER BY columnA DESC) as RowNum\n    FROM \n        someTable\n    ORDER BY \n        columnA DESC\n),\nOtherRow AS (\n    SELECT \n        'Other' as columnB,\n        SUM(columnA) as columnA\n    FROM \n        someTable\n    WHERE \n        columnA NOT IN (SELECT TOP 5 columnA FROM someTable ORDER BY columnA DESC)\n)\nSELECT \n    columnB, columnA\nFROM \n    TopRows\nUNION ALL\nSELECT \n    columnB, columnA\nFROM \n    OtherRow;