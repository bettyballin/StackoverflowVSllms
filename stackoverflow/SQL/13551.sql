INSERT INTO tblSubscriptions (UserID, ProductID, IsActive, SubscriptionDays, Price, MonthlyPrice, ProductType, CurrencyID)\nSELECT UserID, 7, 1, 0, 0, 0, 30, 1 FROM tblUser WHERE ISNULL(SubscriptionType, 0) IN (1, 0)