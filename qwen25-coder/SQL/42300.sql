-- Master ID Table\nCREATE TABLE ObjectIDs (\n    ObjectType CHAR(1) NOT NULL, -- or use an integer if types are numeric\n    ID INT IDENTITY(1,1) PRIMARY KEY CLUSTERED,\n    UniqueID AS (ObjectType + CAST(ID AS VARCHAR(20))) PERSISTED UNIQUE\n);\n\n-- Example Object Table\nCREATE TABLE Orders (\n    OrderID NVARCHAR(21) NOT NULL, -- To store 'O' followed by the numeric ID\n    -- other order details...\n    CONSTRAINT PK_Orders PRIMARY KEY CLUSTERED (OrderID),\n);\n\n-- Insert and Get Unique ID for Orders\nDECLARE @ObjectType CHAR(1) = 'O'; -- 'O' for Order, can set different characters/types\nINSERT INTO ObjectIDs (ObjectType) VALUES (@ObjectType);\nSET @NewOrderID = (SELECT SCOPE_IDENTITY());\n\n-- Format it as needed before inserting into the main table\nINSERT INTO Orders (OrderID) VALUES ('O' + CAST(@NewOrderID AS VARCHAR(20)));\n\n-- For other object types, change @ObjectType accordingly and repeat.