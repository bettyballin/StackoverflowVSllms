SELECT \n    some_table.field1,\n    some_table.field2,\n    another_database.STORED_FUNCTION(arg) AS calculated_field\nFROM \n    some_table\nWHERE \n    ...;