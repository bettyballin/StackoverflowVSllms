-- Example SQL to convert integer price to decimal\nINSERT INTO Products (ProductID, Price)\nSELECT ProductID, CAST(PriceInt AS DECIMAL(10, 2)) / 100\nFROM VendorProducts