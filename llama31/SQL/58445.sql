SELECT MAX(TO_NUMBER(UNID)) FROM myTable WHERE REGEXP_LIKE(UNID, '^[0-9]+$');