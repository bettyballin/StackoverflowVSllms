WITH RankedPurchases AS (\n    SELECT \n        ProductCode,\n        SerialNumber,\n        Quantity,\n        DatePurchased,\n        CustomerID,\n        ROW_NUMBER() OVER (PARTITION BY ProductCode, SerialNumber ORDER BY DatePurchased DESC) as rn\n    FROM YourTableName\n    WHERE CustomerID = 'xxx'\n)\nSELECT \n    ProductCode,\n    SerialNumber,\n    Quantity\nFROM RankedPurchases\nWHERE rn = 1;