DECLARE @image VARBINARY(MAX)\nDECLARE @filePath NVARCHAR(255)\n\nSELECT @image = image_column FROM your_table WHERE id = 1\nSET @filePath = 'C:\image.jpg'\n\nINSERT INTO OPENROWSET('Microsoft.ACE.OLEDB.12.0', \n                        'Excel 12.0;Database=C:\;',\n                        'SELECT * FROM [image.jpg]')\nSELECT @image