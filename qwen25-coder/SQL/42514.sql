SELECT \n    id,\n    LIST(codes USING ', ') AS codes\nFROM \n    your_table_name\nGROUP BY \n    id;