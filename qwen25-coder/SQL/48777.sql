BETWEEN \n  TO_DATE('01/01/' || TO_CHAR(SYSDATE, 'YYYY') || ' 00:00:00', 'DD/MM/YYYY HH24:MI:SS')\nAND\n  TO_DATE('31/12/' || TO_CHAR(SYSDATE, 'YYYY') || ' 23:59:59', 'DD/MM/YYYY HH24:MI:SS')