SELECT u1.*\nFROM user u1\nWHERE u1.banned = 0\n  AND (\n    SELECT COUNT(*)\n    FROM user u2\n    WHERE u2.ip = u1.ip\n      AND u2.banned = 1\n  ) >= 5;