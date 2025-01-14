WITH RECURSIVE Hierarchy AS (\n    SELECT Id, ARRAY[Id] AS Path FROM employee_hierarchy WHERE ParentId IS NULL --root node(s)\n    UNION ALL\n    SELECT e.Id, h.Path || e.Id FROM employee_hierarchy e JOIN Hierarchy h ON e.ParentId = h.Id\n),\nNodePaths AS (\n    SELECT UNNEST(Path) AS Ancestor, Id FROM Hierarchy WHERE Id IN (<list of ids>)\n),\nCommonAncestors AS (\n    SELECT Ancestor FROM NodePaths GROUP BY Ancestor HAVING COUNT(DISTINCT Id) = <number_of_ids>\n)\nSELECT Ancestor FROM CommonAncestors ORDER BY ARRAY_POSITION((SELECT Path FROM Hierarchy LIMIT 1), Ancestor) ASC LIMIT 1;