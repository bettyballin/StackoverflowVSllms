INSERT INTO [WebsiteHistory] (Column1, Column2, Column3, TimestampColumn)\nSELECT Column1, Column2, Column3, GETDATE()\nFROM [Website]