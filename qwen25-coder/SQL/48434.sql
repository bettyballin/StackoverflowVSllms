WITH RECURSIVE cte AS (\n    -- Base: Choose all matches as starting points\n    SELECT \n        asid1 AS node,\n        asid2 AS neighbor\n    FROM \n        #matches\n\n    UNION ALL\n\n    -- Recursive: Find all connected neighbors\n    SELECT \n        c.node,\n        m.asid2 AS neighbor\n    FROM \n        cte c\n    INNER JOIN \n        #matches m ON c.neighbor = m.asid1\n    WHERE \n        NOT EXISTS (SELECT 1 FROM cte WHERE cte.node = c.node AND cte.neighbor = m.asid2)\n)\n\n-- Assign distinct groups based on the reachability from each node\n, Grouped AS (\n    SELECT \n        node,\n        MIN(neighbor) OVER(PARTITION BY node ORDER BY neighbor ASC) as grpMinNeighbor\n    FROM \n        cte\n\n    UNION ALL\n\n    -- Connect nodes with their minimum neighbor to form groups\n    SELECT \n        g.node,\n        MIN(g.grpMinNeighbor, g2.grpMinNeighbor) AS grpMinNeighbor\n    FROM \n        Grouped g\n    INNER JOIN \n        #matches m ON g.node = m.asid1\n    INNER JOIN \n        Grouped g2 ON m.asid2 = g2.node\n    WHERE \n        g.grpMinNeighbor <> g2.grpMinNeighbor\n    GROUP BY \n        g.node\n\n)\n\n-- Final grouping and output selection\nSELECT \n    DENSE_RANK() OVER (ORDER BY grpMinNeighbor) AS grp,\n    node as asid\nFROM (\n    SELECT DISTINCT \n        node,\n        grpMinNeighbor\n    FROM \n        Grouped\n) AS final\nORDER BY grp, asid;