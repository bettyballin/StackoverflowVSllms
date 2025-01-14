-- Example input groups\n-- Group1: Criteria 1 AND 3 AND 4\n-- Group2: Criteria 5 OR 6 OR 7\n-- Group3: Criteria 8 OR 9\n\nWITH Group1 AS (\n    SELECT PersonID\n    FROM PersonCriteria\n    WHERE CriteriaID IN (1, 3, 4)\n    GROUP BY PersonID\n    HAVING COUNT(DISTINCT CriteriaID) = 3\n),\nGroup2 AS (\n    SELECT PersonID\n    FROM PersonCriteria\n    WHERE CriteriaID IN (5, 6, 7)\n),\nGroup3 AS (\n    SELECT PersonID\n    FROM PersonCriteria\n    WHERE CriteriaID IN (8, 9)\n)\n\nSELECT p.PersonID\nFROM Person p\nJOIN Group1 g1 ON p.PersonID = g1.PersonID\nJOIN Group2 g2 ON p.PersonID = g2.PersonID\nJOIN Group3 g3 ON p.PersonID = g3.PersonID;