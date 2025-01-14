SELECT u.user, g.group, u2g.something\nFROM users u\nJOIN u2g u2g3 ON u.u = u2g3.u AND u2g3.g = 3\nJOIN u2g u2g5 ON u.u = u2g5.u AND u2g5.g = 5\nJOIN groups g ON g.g IN (3, 5)\nWHERE u2g3.u = u2g5.u;