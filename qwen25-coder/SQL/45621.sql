DECLARE @sql NVARCHAR(MAX) = N'';\n\nSELECT @sql += 'ALTER TABLE [' + SCHEMA_NAME(t.schema_id) \n              + '].[' + t.name + '] DROP CONSTRAINT [' + fk.name + '];' +\n              'ALTER TABLE [' + SCHEMA_NAME(t.schema_id) \n              + '].[' + t.name + '] WITH CHECK ADD CONSTRAINT ' \n              + QUOTENAME(fk.name) + \n              ' FOREIGN KEY(' + COL_NAME(fc.parent_object_id,fc.parent_column_id) +\n              ') REFERENCES [' + SCHEMA_NAME(trg.schema_id) + '].['\n              + trg.name + '] (' \n              + COL_NAME(fc.referenced_object_id,fc.referenced_column_id) +\n              ');'\nFROM sys.foreign_keys AS fk\nINNER JOIN sys.tables AS t ON fk.parent_object_id = t.object_id\nINNER JOIN sys.tables AS trg ON fk.referenced_object_id = trg.object_id\nINNER JOIN sys.foreign_key_columns AS fc ON fc.constraint_object_id = fk.object_id;\n\nEXEC sp_executesql @sql;