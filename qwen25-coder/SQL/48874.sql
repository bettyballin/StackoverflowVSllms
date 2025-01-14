SELECT p.ProfileID, p.UserID, p.ProfileLanguage, p.ProfilePriority\nFROM Profile p\nJOIN (\n    SELECT UserID, MIN(ProfilePriority) AS MinProfilePriority\n    FROM Profile\n    WHERE ProfileLanguage = 'es-MX' OR ProfilePriority = 2\n    GROUP BY UserID\n) sub ON p.UserID = sub.UserID AND p.ProfilePriority = sub.MinProfilePriority;