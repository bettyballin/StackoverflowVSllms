DECLARE @InsertedID TABLE (ID INT);\n\nINSERT INTO YourTable(foreign_key1, value)\nOUTPUT INSERTED.key_field INTO @InsertedID (ID)\nVALUES (9, 'text');\n\nSELECT ID FROM @InsertedID;