SELECT  sys.objects.name, sys.schemas.name AS schema_name\nFROM    sys.objects \nINNER JOIN sys.schemas ON sys.objects.schema_id = sys.schemas.schema_id