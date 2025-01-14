-- Insert missing records in Table A from DEV to TEST\nINSERT INTO TEST.dbo.TableA (name)\nSELECT name FROM DEV.dbo.TableA a\nLEFT JOIN TEST.dbo.TableA b ON a.name = b.name\nWHERE b.name IS NULL;\n\n-- Insert missing records in Table B from DEV to TEST\nINSERT INTO TEST.dbo.TableB (fk_id, item)\nSELECT b.fk_id, b.item\nFROM DEV.dbo.TableB b\nJOIN DEV.dbo.TableA a ON b.fk_id = a.id\nJOIN TEST.dbo.TableA ta ON a.name = ta.name\nLEFT JOIN TEST.dbo.TableB tb ON tb.item = b.item AND tb.fk_id = ta.id\nWHERE tb.item IS NULL;