SELECT TO_DATE(\n           LPAD(SUBSTR(TO_CHAR(a.A_DATE, 'DD.MM.YYYY'), 4, 2), 2, '0') || '.' ||\n           LPAD(SUBSTR(TO_CHAR(a.A_DATE, 'DD.MM.YYYY'), 1, 2), 2, '0') || \n           SUBSTR(TO_CHAR(a.A_DATE, 'DD.MM.YYYY'), 6, 4),\n           'DD.MM.YYYY')\n  FROM table1 a;