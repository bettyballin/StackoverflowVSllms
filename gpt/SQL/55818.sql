SELECT \n    field_name,\n    CAST(field_name AS VARBINARY(MAX)) AS BinaryData\nFROM \n    table_name;