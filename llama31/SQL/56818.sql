SELECT P1.*\nFROM Profile P1\nINNER JOIN (\n  SELECT UserID, MIN(ProfilePriority) AS ProfilePriority\n  FROM Profile\n  WHERE ProfileLanguage = 'es-MX' OR ProfilePriority = 2\n  GROUP BY UserID\n) P2\nON P1.UserID = P2.UserID AND P1.ProfilePriority = P2.ProfilePriority