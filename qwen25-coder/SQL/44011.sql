SELECT OBJECT_NAME AS PackageName,\n       PROCEDURE_NAME,\n       OBJECT_TYPE\nFROM ALL_PROCEDURES\nWHERE PACKAGE_NAME = 'YOUR_PACKAGE_NAME'\nAND OWNER = 'OWNER_SCHEMA_NAME'\nORDER BY PROCEDURE_NAME;