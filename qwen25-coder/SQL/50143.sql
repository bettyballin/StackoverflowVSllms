INSERT INTO tblSubscriptions (UserID, ProductID, isACtive, SubscriptionDays, Price, MonthlyPrice, ProductType, CurrencyID)\nSELECT UserID, 7, 1, 0, 0, 0, 30, 1\nFROM tblUser\nWHERE SubscriptionType IN (1, 0) OR SubscriptionType IS NULL;