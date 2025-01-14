-- Create a mapping table\nCREATE TABLE ProductCategory (\n    ProductName NVARCHAR(50),\n    Category NVARCHAR(50)\n);\n\nINSERT INTO ProductCategory (ProductName, Category) VALUES ('Apple', 'Fruit');\nINSERT INTO ProductCategory (ProductName, Category) VALUES ('Orange', 'Fruit');\nINSERT INTO ProductCategory (ProductName, Category) VALUES ('Banana', 'Fruit');\n\n-- Use the mapping table in your query\nSELECT \n    COALESCE(pc.Category, t.Product) AS Product,\n    t.Quantity\nFROM \n    YourTable t\nLEFT JOIN \n    ProductCategory pc ON t.Product = pc.ProductName;