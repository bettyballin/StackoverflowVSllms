-- Preferred ANSI standard\nSELECT * FROM MyTable WHERE ColumnName <> 'someValue';\n\n-- Also works but less preferred for strict standards adherence\nSELECT * FROM MyTable WHERE ColumnName != 'someValue';