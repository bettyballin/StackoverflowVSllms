CREATE PROC Delete_Product \n(\n    @ProductID uniqueidentifier\n) \nAS \nBEGIN\n    DELETE FROM tblProduct \n    WHERE ProductID = @ProductID\nEND