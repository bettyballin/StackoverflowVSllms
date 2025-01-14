SELECT 'CREATE ASSEMBLY [' + name + '] FROM ' + \n          '0x' + convert(varchar(max), master.sys.fn_varbintohexstr(content)) +\n          ' WITH PERMISSION_SET = ' + permission_set_desc\n   FROM sys.assemblies AS asm\n   JOIN sys.assembly_files AS asm_files\n   ON asm.assembly_id = asm_files.assembly_id\n   WHERE is_user_defined = 1;