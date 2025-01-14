SELECT SUM(subq.TOTALSALES) AS TOTAL_REVENUE\nFROM (\n    SELECT TICKET_TYPE.PRICE AS TOTALSALES\n    FROM RESERVATION, TICKET, TICKET_TYPE, CINEMA, PERFORMANCE\n    WHERE TICKET_TYPE.TICKET_TYPE_ID = TICKET.TICKET_TYPE_ID\n      AND TICKET.RESERVATION_ID = RESERVATION.RESERVATION_ID\n      AND RESERVATION.PERFORMANCE_ID = PERFORMANCE.PERFORMANCE_ID\n      AND CINEMA.LOCATION = 'sometown'\n      AND PERFORMANCE.PERFORMANCE_DATE = to_date('01/03/2009','DD/MM/yyyy')\n) subq;