-- Assuming you have a unified table named 'Customers' with a siteId column\nCREATE VIEW Client1_Customers AS\nSELECT * FROM Customers\nWHERE siteId = 1;\n\nCREATE VIEW Client2_Customers AS\nSELECT * FROM Customers\nWHERE siteId = 2;