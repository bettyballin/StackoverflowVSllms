CREATE TABLE CustomerTypeA (\n    CustomerId INT PRIMARY KEY,\n    -- other columns specific to Type A customers\n);\n\nCREATE TABLE CustomerTypeB (\n    CustomerId INT PRIMARY KEY,\n    -- other columns specific to Type B customers\n);\n\nCREATE TABLE Order (\n    OrderId INT PRIMARY KEY,\n    CustomerId INT,\n    -- other order columns\n    CONSTRAINT FK_Order_CustomerTypeA FOREIGN KEY (CustomerId) REFERENCES CustomerTypeA(CustomerId),\n    CONSTRAINT FK_Order_CustomerTypeB FOREIGN KEY (CustomerId) REFERENCES CustomerTypeB(CustomerId)\n);