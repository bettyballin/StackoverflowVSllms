SELECT *\nFROM EMPLOYEES\nWHERE OFFICE_ID IN (SELECT COLUMN_VALUE FROM TABLE(GET_OFFICE_IDS()));