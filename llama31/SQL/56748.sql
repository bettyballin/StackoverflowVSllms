-- Add ON DELETE CASCADE to all foreign keys\nSELECT 'ALTER TABLE [' + OBJECT_NAME(fk.parent_object_id) + '] \n       ALTER CONSTRAINT [' + fk.name + '] \n       ON DELETE CASCADE;' \nFROM sys.foreign_keys AS fk;\n\n-- Remove ON DELETE CASCADE from all foreign keys\nSELECT 'ALTER TABLE [' + OBJECT_NAME(fk.parent_object_id) + '] \n       ALTER CONSTRAINT [' + fk.name + '] \n       ON DELETE NO ACTION;' \nFROM sys.foreign_keys AS fk;