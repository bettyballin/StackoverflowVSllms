EXEC SQL BEGIN DECLARE SECTION;\n     long julian_date;\n   EXEC SQL END DECLARE SECTION;\n\n   EXEC SQL SELECT TO_NUMBER(TO_CHAR(your_date_column, 'J')) INTO :julian_date FROM your_table;