CREATE PROC Read_Products\n(\n    @ProductID uniqueidentifier = NULL,\n    @IDProductType uniqueidentifier = NULL,\n    @ProductName nvarchar(255) = NULL,\n    @ProductCode nvarchar(50) = NULL\n)\nAS \nBEGIN\n    SELECT \n        ProductID,\n        IDProductType,\n        ProductName,\n        ProductCode,\n        Weight,\n        Volume\n    FROM \n        tblProduct\n    WHERE \n        (@ProductID IS NULL OR ProductID = @ProductID) AND\n        (@IDProductType IS NULL OR IDProductType = @IDProductType) AND\n        (@ProductName IS NULL OR ProductName LIKE '%' + @ProductName + '%') AND\n        (@ProductCode IS NULL OR ProductCode LIKE '%' + @ProductCode + '%')\nEND