BETWEEN \n  TO_DATE('01/01/' || EXTRACT(YEAR FROM SYSDATE) || ' 00:00:00', 'DD/MM/YYYY HH24:MI:SS')\nAND\n  TO_DATE('31/12/' || EXTRACT(YEAR FROM SYSDATE) || ' 23:59:59', 'DD/MM/YYYY HH24:MI:SS')