-- Check current owners of tables and views\nSELECT \n    SCHEMA_NAME(schema_id) + '.' + name AS [ObjectName], \n    USER_NAME(owner_sid) AS OwnerName\nFROM sys.objects\nWHERE name IN ('Persons', 'PhoneNumbers', 'vtPersons', 'vtPhoneNumbers', 'vwContactInformation');\n\n-- Change ownership if necessary, replacing 'dbo' with the appropriate schema owner\nALTER AUTHORIZATION ON SCHEMA::People TO dbo;