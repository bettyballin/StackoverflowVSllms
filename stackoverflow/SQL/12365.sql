select\n'select distinct ''' + schem.name + '.' + tab.name + '.' + col.name\n+ ''' from [' + schem.name + '].[' + tab.name\n+ '] where [' + col.name + '] like ''%MISSPELLING HERE%'' union '\nfrom [sys].tables tab\njoin [sys].schemas schem ON (tab.schema_id = schem.schema_id)\njoin [sys].columns col on (tab.object_id = col.object_id)\njoin [sys].types types on (col.system_type_id = types.system_type_id)\nwhere tab.type_desc = 'USER_TABLE'\nand types.name IN ('CHAR', 'NCHAR', 'VARCHAR', 'NVARCHAR');