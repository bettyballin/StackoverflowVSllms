-- disable all constraints\nEXEC sp_MSforeachtable "ALTER TABLE ? NOCHECK CONSTRAINT all"