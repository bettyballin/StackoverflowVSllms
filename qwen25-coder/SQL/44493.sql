DECLARE @imageData VARBINARY(MAX);\nSET @imageData = (SELECT ImageColumn FROM YourTable WHERE ID = 1);\n\nEXEC dbo.SaveImageToFileProc @ImageData, N'C:\Path\To\Save\Image.jpg';