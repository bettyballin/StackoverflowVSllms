-- Search in procedures, functions, packages, triggers, views\nSELECT owner, name, type, line, text\nFROM dba_source\nWHERE UPPER(text) LIKE UPPER('%search string%');\n\n-- Search in views\nSELECT owner, view_name, text\nFROM dba_views\nWHERE UPPER(text) LIKE UPPER('%search string%');