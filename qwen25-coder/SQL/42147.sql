WITH RECURSIVE cte AS (\n    SELECT NodeID, ParentNodeID, EffectiveFrom, EffectiveTo\n    FROM Hierarchy\n    WHERE NodeID = :startNodeId AND :queryDate BETWEEN EffectiveFrom AND EffectiveTo\n    UNION ALL\n    SELECT h.NodeID, h.ParentNodeID, h.EffectiveFrom, h.EffectiveTo\n    FROM cte\n    JOIN Hierarchy h ON cte.NodeID = h.ParentNodeID\n    WHERE :queryDate BETWEEN h.EffectiveFrom AND h.EffectiveTo\n)\nSELECT NodeID, ParentNodeID\nFROM cte;