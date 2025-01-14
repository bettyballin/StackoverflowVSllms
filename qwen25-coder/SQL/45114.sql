SELECT \n    r.amount,\n    s.total_sum\nFROM \n    (SELECT TOP 5 amount \n     FROM table \n     ORDER BY amount DESC) r\nCROSS JOIN \n    (SELECT SUM(amount) AS total_sum FROM table) s;