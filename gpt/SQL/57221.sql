EXEC SQL BEGIN DECLARE SECTION;\n   long days_since_base;\n   EXEC SQL END DECLARE SECTION;\n\n   EXEC SQL SELECT (date_column - TO_DATE('1899-12-31', 'YYYY-MM-DD')) INTO :days_since_base FROM table_name;