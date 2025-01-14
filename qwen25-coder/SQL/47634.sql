CREATE VIEW dbo.HierarchicalDataView AS\nWITH RecursiveHierarchy (Id, Name, ParentId)\nAS (\n    -- Anchor member: select the root node(s) (e.g., where ParentId is NULL or a specific condition)\n    SELECT Id, Name, ParentId\n    FROM YourTable\n    WHERE ParentId IS NULL\n\n    UNION ALL\n\n    -- Recursive member: join with the anchor to fetch child nodes\n    SELECT t.Id, t.Name, t.ParentId\n    FROM YourTable t\n    INNER JOIN RecursiveHierarchy rh ON t.ParentId = rh.Id\n)\nSELECT Id, Name, ParentId\nFROM RecursiveHierarchy;