CREATE TABLE ImageCatalog (\n    ImageID INT IDENTITY(1,1) PRIMARY KEY,\n    ImageName NVARCHAR(255),\n    ImageData VARBINARY(MAX)\n);