SELECT \n    Users.MemberId, \n    PremiumUsers.IsActive \nFROM \n    Users\nLEFT JOIN \n    PremiumUsers ON PremiumUsers.UserId = Users.Id\nORDER BY \n    CASE \n        WHEN PremiumUsers.IsActive = 1 THEN 1 \n        WHEN PremiumUsers.IsActive IS NULL THEN 2 \n        ELSE 3 \n    END, \n    Users.MemberId;