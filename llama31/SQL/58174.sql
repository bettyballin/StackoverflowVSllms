WITH Dates AS (\n    SELECT TOP 30  -- Adjust this to generate more dates if needed\n        DATEADD(DAY, ROW_NUMBER() OVER (ORDER BY t1.object_id), @StartDate) AS TestDate\n    FROM master.sys.all_columns t1\n    CROSS JOIN master.sys.all_columns t2\n),\nPersonSite AS (\n    SELECT \n        P.PersonID,\n        P.PersonName,\n        S.SiteID,\n        S.SiteNm,\n        (ROW_NUMBER() OVER (PARTITION BY S.SiteID ORDER BY P.PersonID) - 1) % @PeoplePerSite + 1 AS PersonOrder,\n        (ROW_NUMBER() OVER (PARTITION BY S.SiteID ORDER BY P.PersonID) - 1) / @PairSize + 1 AS PairGroup\n    FROM \n        @Person P\n    JOIN \n        @Site S ON P.SiteID = S.SiteID\n)