DELIMITER $$\n\nDROP PROCEDURE IF EXISTS SP1 $$\nCREATE PROCEDURE SP1(InputCustomerID INT, InputOrderID INT)\nBEGIN\n    -- Assuming you want to insert some data into tb1 based on inputs\n    INSERT INTO tb1 (CustomerID, OrderID) VALUES (InputCustomerID, InputOrderID);\nEND $$\n\nDELIMITER ;\n\nDELIMITER $$\n\nDROP PROCEDURE IF EXISTS SP2 $$\nCREATE PROCEDURE SP2()\nBEGIN\n    DECLARE InputCustomerID INT;\n    DECLARE InputOrderID INT;\n\n    -- Initialize variables to avoid NULL-related errors\n    SET @InputCustomerID = 0;\n    SET @InputOrderID = 0;\n\n    -- Fetching the required inputs\n    SELECT CustomerID INTO @InputCustomerID \n    FROM Customers \n    WHERE CustomerID NOT IN (SELECT FK_CustomerID FROM CustomerOrders) \n      AND IsApproved = TRUE \n      AND CustomerID IN (\n          SELECT FK_CustomerID \n          FROM CustomerProductOrders \n          WHERE DATE(OrderStartDate) = CURDATE()\n      );\n\n    SELECT OrderID INTO @InputOrderID \n    FROM CustomerOrders \n    WHERE FK_CustomerID NOT IN (SELECT FK_CustomerID FROM CustomerProductOrders) \n      AND IsApproved = TRUE \n      AND DATE(OrderStartDate) = CURDATE();\n\n    -- Calling SP1 with fetched values\n    CALL SP1(@InputCustomerID, @InputOrderID);\nEND $$\n\nDELIMITER ;