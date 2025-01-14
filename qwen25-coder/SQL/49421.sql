DECLARE @Protocols TABLE(ProtocolID INT NOT NULL)\n\nINSERT INTO @Protocols (ProtocolID)\nSELECT ProtocolID\nFROM dbo.Protocols\nWHERE WorkplaceID = @WorkplaceID\n\nDELETE FROM dbo.SubProtocols\nWHERE ProtocolID IN (SELECT ProtocolID FROM @Protocols)\n\nDELETE FROM dbo.ProtocolHeaders\nWHERE ProtocolID IN (SELECT ProtocolID FROM @Protocols)\n\n-- Delete from other tables similarly\n\nDELETE FROM dbo.Protocols\nWHERE WorkplaceID = @WorkplaceID