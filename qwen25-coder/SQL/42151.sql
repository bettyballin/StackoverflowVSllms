SELECT * FROM sys.triggers WHERE parent_id = OBJECT_ID('Department');\n   SELECT * FROM sys.objects WHERE object_id = OBJECTPROPERTY(OBJECT_ID('Department'), 'TableHasCheckConstraint');