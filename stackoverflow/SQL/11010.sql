CREATE PARTITION FUNCTION MyArchive(datetime)\nAS RANGE LEFT FOR VALUES (GETDATE() – 10)\nGO