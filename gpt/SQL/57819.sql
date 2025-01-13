SELECT u.user, g.group, u2g.something\nFROM users u\nJOIN u2g u2g ON u.u = u2g.u\nJOIN groups g ON g.g = u2g.g\nWHERE u2g.g IN (3, 5)\n  AND u.u IN (\n    SELECT u2g1.u\n    FROM u2g u2g1\n    WHERE u2g1.g = 3\n  )\n  AND u.u IN (\n    SELECT u2g2.u\n    FROM u2g u2g2\n    WHERE u2g2.g = 5\n  )\nORDER BY u.user, g.group;