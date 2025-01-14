-- Assume @andCriteria is a list of criteria IDs that need to be entirely matched (e.g., 1, 3, 4)\n-- Assume @orGroups is an array where each entry is an array itself (e.g., [[5, 6, 7], [8, 9]])\n\nDECLARE @andCriteria TABLE (CriteriaID INT);\nINSERT INTO @andCriteria VALUES (1), (3), (4);\n\nDECLARE @orGroups TABLE (GroupID INT IDENTITY(1,1), CriteriaIDs VARCHAR(MAX));\nINSERT INTO @orGroups VALUES ('5,6,7'), ('8,9');\n\n-- Temporary table to store IDs that match the AND criteria\nSELECT DISTINCT p.PersonID \nINTO #MatchedAndCriteria\nFROM Person p\nJOIN PersonCriteria pc ON p.PersonID = pc.PersonID\nWHERE pc.CriteriaID IN (SELECT CriteriaID FROM @andCriteria)\nGROUP BY p.PersonID\nHAVING COUNT(DISTINCT pc.CriteriaID) = (SELECT COUNT(*) FROM @andCriteria);\n\n-- Query to find matching IDs in OR groups\nWITH ORGroupMatches AS (\n    SELECT g.GroupID, p.PersonID\n    FROM Person p\n    JOIN PersonCriteria pc ON p.PersonID = pc.PersonID\n    CROSS APPLY STRING_SPLIT(g.CriteriaIDs, ',') s(CriteriaID)\n    JOIN @orGroups g ON 1=1\n    WHERE pc.CriteriaID = CAST(s.CriteriaID AS INT)\n),\nGroupResults AS (\n    SELECT gm.PersonID\n    FROM ORGroupMatches gm\n    GROUP BY gm.PersonID, gm.GroupID\n)\n\n-- Get final results matching all AND criteria and any one in each OR group\nSELECT DISTINCT m.AndPersonID\nFROM #MatchedAndCriteria m\nJOIN GroupResults g ON m.PersonID = g.PersonID\nGROUP BY m.PersonID\nHAVING COUNT(DISTINCT g.GroupID) = (SELECT COUNT(*) FROM @orGroups);\n\n-- Cleanup temp table\nDROP TABLE #MatchedAndCriteria;