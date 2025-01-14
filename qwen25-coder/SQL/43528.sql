DECLARE @prefix NVARCHAR(128) = N'SitePrefix_';  -- Replace 'SitePrefix_' with your actual prefix\n\nSELECT \n    schema_name(schema_id) AS schema_name,\n    o.name AS object_name,\n    type_desc \nFROM sys.objects o\nWHERE o.name LIKE @prefix + '%';