DECLARE @sql nvarchar(max)\n\nSELECT @sql = OBJECT_DEFINITION(OBJECT_ID('your_stored_procedure_name'))\n\nPRINT @sql