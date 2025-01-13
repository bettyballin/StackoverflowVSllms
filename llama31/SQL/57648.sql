CREATE TABLE date_ranges (\n  start_date TIMESTAMP,\n  end_date TIMESTAMP\n);\n\nINSERT INTO date_ranges (start_date, end_date)\nVALUES (TRUNC(SYSDATE, 'DD'), TRUNC(SYSDATE + 1, 'DD'));\n\nSELECT * FROM date_ranges\nWHERE start_date <= SYSTIMESTAMP AND end_date > SYSTIMESTAMP;