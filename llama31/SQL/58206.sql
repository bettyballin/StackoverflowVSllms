CREATE TABLE DOC_Documents (\n    DOC_ID INT IDENTITY(1,1),\n    DOC_Order INT DEFAULT ([dbo].[NEWDOC_Order]()),\n    DOC_Name VARCHAR(50)\n)