DELETE FROM Hierarchy\nWHERE NodeID IN (\n    WITH RecursiveCTE AS (\n        SELECT NodeID\n        FROM Hierarchy\n        WHERE NodeID = @NodeToDelete\n\n        UNION ALL\n\n        SELECT h.NodeID\n        FROM Hierarchy h\n        INNER JOIN RecursiveCTE rc ON rc.NodeID = h.ParentNodeID\n    )\n    SELECT NodeID FROM RecursiveCTE\n);