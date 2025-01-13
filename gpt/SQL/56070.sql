SELECT \n    colname AS "Column Name", \n    typename AS "Data Type", \n    length AS "Length", \n    scale AS "Scale", \n    nulls AS "Nullable"\nFROM \n    syscat.columns\nWHERE \n    tabname = 'TABLE_NAME' \n    AND tabschema = 'SCHEMA_NAME'\nORDER BY \n    colno;