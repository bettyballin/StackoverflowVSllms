SELECT *\nFROM (\n    SELECT TOP 5 rootcause, COUNT(IIF(accountability="Team 1",1,0)) AS CountTeam1\n    FROM MOAQ\n    WHERE CDT=1\n    GROUP BY rootcause\n    ORDER BY COUNT(IIF(accountability="Team 1",1,0)) DESC\n) AS SubQuery\nORDER BY rootcause;