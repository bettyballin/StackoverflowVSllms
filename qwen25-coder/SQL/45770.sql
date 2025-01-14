SELECT (TO_NUMBER(TO_CHAR(date_column, 'DDD')) - TO_NUMBER(TO_CHAR('1900-01-01', 'DDD'))\n          + 365 * (EXTRACT(YEAR FROM date_column) - 1900)\n          + FLOOR((EXTRACT(YEAR FROM date_column) - 1899) / 4) \n          - FLOOR((EXTRACT(YEAR FROM date_column) - 1899) / 100) \n          + FLOOR((EXTRACT(YEAR FROM date_column) - 1899) / 400)) AS days_since_1899\n   FROM your_table;